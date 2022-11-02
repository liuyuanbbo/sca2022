package sb.minio.filter;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Slf4j
@Order(10)
public class HeaderFilter extends OncePerRequestFilter {

    @Value("${head.jsId}")
    private String jsId;

    @Value("${head.urls:/a01/**}")
    private String urls;

    private static final AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        String[] items = StringUtils.splitByWholeSeparatorPreserveAllTokens(urls, ",");
        boolean flag = false;
        for (String item : items) {
            if (antPathMatcher.match(item, requestURI)) {
                flag = true;
            }
        }
        if (flag) {
            filterChain.doFilter(request, response);
            log.info("HeadFilter 过滤器执行完毕");
            return;
        }

        String certId = request.getHeader("certId");
        String cusName = request.getHeader("cusName");
        String name = request.getParameter("name");
        log.info("jdId: {} >>> {} {} {}", jsId, certId, cusName, name);
        filterChain.doFilter(request, response);
    }
}
