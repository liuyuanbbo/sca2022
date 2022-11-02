package sb.minio.filter;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Slf4j
@Order(10)
public class V1Filter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info("V1 V1 111============");
        String v1 = request.getHeader("v1");
        if (StringUtils.isNotBlank(v1)) {
            log.info("头部V1");
            filterChain.doFilter(request, response);
            return;
        }
        log.info("头部不带V1参数");
        filterChain.doFilter(request, response);

    }
}
