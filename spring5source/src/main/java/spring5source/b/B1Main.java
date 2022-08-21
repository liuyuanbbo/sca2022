package spring5source.b;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import spring5source.b.extend.BMyRequestMappingHandlerAdapter;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Slf4j
public class B1Main {
    public static void main(String[] args) throws Exception {
        AnnotationConfigServletWebServerApplicationContext ctx
                = new AnnotationConfigServletWebServerApplicationContext(B1Config.class);
        RequestMappingHandlerMapping handlerMapping
                = ctx.getBean(RequestMappingHandlerMapping.class);

        Map<RequestMappingInfo, HandlerMethod> handlerMethods
                = handlerMapping.getHandlerMethods();

        handlerMethods.forEach((k, v) -> log.info("{} ==> {}", k, v));

        log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        MockHttpServletRequest request = new MockHttpServletRequest("POST", "/test4");
        request.addHeader("token", UUID.randomUUID().toString());
        MockHttpServletResponse response = new MockHttpServletResponse();
        log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        HandlerExecutionChain chain = handlerMapping.getHandler(request);
        log.info("{}", chain);

        log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        BMyRequestMappingHandlerAdapter handlerAdapter = ctx.getBean(BMyRequestMappingHandlerAdapter.class);
        handlerAdapter.invokeHandlerMethod(request, response, (HandlerMethod) chain.getHandler());
        byte[] array = response.getContentAsByteArray();
        log.info("{}", new String(array, StandardCharsets.UTF_8));
        log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 所有参数解析器");
        List<HandlerMethodArgumentResolver> argumentResolvers = handlerAdapter.getArgumentResolvers();
        log.info("{}", argumentResolvers.size());
        for (HandlerMethodArgumentResolver resolver : argumentResolvers) {
            //log.info("{}", resolver);
        }
        log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 所有返回值解析器");
        List<HandlerMethodReturnValueHandler> returnValueHandlers = handlerAdapter.getReturnValueHandlers();
        log.info("{}", returnValueHandlers.size());
        for (HandlerMethodReturnValueHandler returnValueHandler : returnValueHandlers) {
            //log.info("{}", returnValueHandler);
        }
    }

}
