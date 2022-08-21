package spring5source.b;

import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletRegistrationBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import spring5source.b.extend.BMyRequestMappingHandlerAdapter;
import spring5source.b.properties.B1Properties;
import spring5source.b.properties.B2Properties;
import spring5source.b.resolver.TokenArgumentResolver;
import spring5source.b.resolver.YmlReturnValueHandlerResolver;

import java.util.List;

@Configuration
@ComponentScan
@PropertySource({"classpath:b/b1.properties", "classpath:b/b2.properties"})
@EnableConfigurationProperties({B1Properties.class, B2Properties.class})
public class B1Config {
    @Bean
    public TomcatServletWebServerFactory tomcatServletWebServerFactory(B1Properties b1Properties) {
        return new TomcatServletWebServerFactory(b1Properties.getPort());
    }

    @Bean
    public DispatcherServlet dispatcherServlet() {
        return new DispatcherServlet();
    }

    @Bean
    public DispatcherServletRegistrationBean registrationBean(DispatcherServlet dispatcherServlet, B2Properties b2Properties) {
        DispatcherServletRegistrationBean registrationBean = new DispatcherServletRegistrationBean(dispatcherServlet, b2Properties.getPath());
        registrationBean.setLoadOnStartup(b2Properties.getLoadOnStartup());
        return registrationBean;
    }

    @Bean
    public RequestMappingHandlerMapping requestMappingHandlerMapping() {
        return new RequestMappingHandlerMapping();
    }

    @Bean
    public BMyRequestMappingHandlerAdapter bMyRequestMappingHandlerAdapter() {
        BMyRequestMappingHandlerAdapter handlerAdapter = new BMyRequestMappingHandlerAdapter();
        TokenArgumentResolver tokenArgumentResolver = new TokenArgumentResolver();
        YmlReturnValueHandlerResolver ymlReturnValueHandlerResolver = new YmlReturnValueHandlerResolver();
        handlerAdapter.setCustomArgumentResolvers(List.of(tokenArgumentResolver));
        handlerAdapter.setCustomReturnValueHandlers(List.of(ymlReturnValueHandlerResolver));
        return handlerAdapter;
    }
}
