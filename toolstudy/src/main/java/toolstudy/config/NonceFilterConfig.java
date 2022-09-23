package toolstudy.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.HandlerExceptionResolver;
import toolstudy.properties.IgnoreUrlProperties;

import javax.annotation.PostConstruct;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class NonceFilterConfig {

    @Value("${security.antiReply.timestamp:5}")
    private Integer antiReplyTimestamp;
    private final IgnoreUrlProperties ignoreUrlProperties;
    private final HandlerExceptionResolver handlerExceptionResolver;
    private final StringRedisTemplate stringRedisTemplate;

    @PostConstruct
    public void init() {
        log.info("{}", ignoreUrlProperties.getUrls());
    }

//    @Bean
//    @ConditionalOnMissingFilterBean
//    public FilterRegistrationBean<Filter> nonceFilter() {
//        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
//        NonceFilter nonceFilter = new NonceFilter(ignoreUrlProperties.getUrls());
//        nonceFilter.setHandlerExceptionResolver(handlerExceptionResolver);
//        nonceFilter.setStringRedisTemplate(stringRedisTemplate);
//        nonceFilter.setAntiReplyTimestamp(antiReplyTimestamp);
//        nonceFilter.setIgnoreUrls(ignoreUrlProperties.getUrls());
//
//        filterRegistrationBean.setFilter(nonceFilter);
//        return filterRegistrationBean;
//    }

}
