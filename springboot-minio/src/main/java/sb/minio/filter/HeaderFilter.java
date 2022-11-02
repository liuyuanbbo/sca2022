package sb.minio.filter;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Slf4j
public class HeaderFilter extends OncePerRequestFilter {

    @Value("${head.jsId}")
    private String jsId;

    @Value("${head.urls:/a/**}")
    private String urls;

    //private static final AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String[] items = StringUtils.splitByWholeSeparatorPreserveAllTokens(urls, ",");
        boolean flag = false;

        String requestURI = request.getRequestURI();
        String certId = request.getHeader("certId");
        String cusName = request.getHeader("cusName");
        String name = request.getParameter("name");
        log.info("jdId: {} >>> {} {} {}", jsId, certId, cusName, name);
        filterChain.doFilter(request, response);
    }
}
