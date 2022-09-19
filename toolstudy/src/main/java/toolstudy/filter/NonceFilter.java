package toolstudy.filter;

import cn.hutool.core.util.RandomUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.support.RequestContextUtils;
import toolstudy.anno.AntiReply;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
@RequiredArgsConstructor
public class NonceFilter extends OncePerRequestFilter {

    private static RequestMappingHandlerMapping requestMappingHandlerMapping;

    @Value("${security.antiReply.timestamp:5}")
    private Integer antiReplyTimestamp;

    private final HandlerExceptionResolver handlerExceptionResolver;
    private final StringRedisTemplate stringRedisTemplate;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        HandlerExecutionChain chain;
        if (requestMappingHandlerMapping == null) {
            requestMappingHandlerMapping = getRequestMappingHandlerMapping(request);
        }
        String requestURI = request.getRequestURI();
        try {
            chain = requestMappingHandlerMapping.getHandler(request);
        } catch (Exception e) {
            log.error("执行失败: 请求路径: {} , 异常信息:  {}", requestURI, e.getMessage());
            throw new RuntimeException(e);
        }
        if (chain == null) {
            log.info("NonceFilter执行失败 , 找不到 [{}]", requestURI);
            filterChain.doFilter(request, response);
            return;
        }
        HandlerMethod handlerMethod = (HandlerMethod) chain.getHandler();
        Method method = handlerMethod.getMethod();
        if (method.isAnnotationPresent(AntiReply.class)) {
            //String nonceToken = request.getParameter("nonce_token");
            //String timestamp = request.getParameter("timestamp");
            String nonceToken = UUID.randomUUID().toString().replace("-", "");
            String timestamp = String.valueOf(System.currentTimeMillis() - RandomUtil.randomLong(10000, 40000));

            if (StringUtils.isBlank(nonceToken) || StringUtils.isBlank(timestamp)) {
                log.error("参数 nonce_token : [{}] 和 timestamp: [{}] 不能为空 ", nonceToken, timestamp);
                handlerExceptionResolver.resolveException(request, response, null, new IllegalArgumentException("参数 nonce_token : " + nonceToken + "  timestamp: " + timestamp));
                return;
            }

            long current = System.currentTimeMillis();
            long t = Long.parseLong(timestamp);
            if (current < t || (current - t) > antiReplyTimestamp * 60 * 1000) {
                log.error("NonceFilter校验不通过,未在配置时间内,当前时间戳: {} , 参数时间戳: {} , 配置有效时间: {} 分钟 ", current, t, antiReplyTimestamp);
                handlerExceptionResolver.resolveException(request, response, null, new RuntimeException("无效请求"));
                return;
            }
            String key = "eqb_funds_antiReply_" + nonceToken;
            Boolean succ = stringRedisTemplate.opsForValue().setIfAbsent(key, "1", antiReplyTimestamp, TimeUnit.MINUTES);
            if (Boolean.FALSE.equals(succ)) {
                log.error("nonceToken已存在", nonceToken);
                handlerExceptionResolver.resolveException(request, response, null, new RuntimeException("无效请求"));
                return;
            }
            filterChain.doFilter(request, response);
        }
    }

    private RequestMappingHandlerMapping getRequestMappingHandlerMapping(HttpServletRequest request) {
        if (requestMappingHandlerMapping != null) {
            return requestMappingHandlerMapping;
        }
        WebApplicationContext wac = RequestContextUtils.findWebApplicationContext(request);
        return BeanFactoryUtils.beanOfTypeIncludingAncestors(wac, RequestMappingHandlerMapping.class, true, false);
    }
}
