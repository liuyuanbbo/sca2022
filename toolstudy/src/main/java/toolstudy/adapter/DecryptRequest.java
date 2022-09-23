package toolstudy.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdviceAdapter;
import toolstudy.anno.Decrypt;
import toolstudy.properties.KeyProperties;
import toolstudy.utils.AESUtils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;

@EnableConfigurationProperties(KeyProperties.class)
@ControllerAdvice
public class DecryptRequest extends RequestBodyAdviceAdapter {

    @Autowired
    private KeyProperties keyProperties;

    /**
     * 该方法用于判断当前请求，是否要执行beforeBodyRead方法
     *
     * @param methodParameter handler方法的参数对象
     * @param targetType      handler方法的参数类型
     * @param converterType   将会使用到的Http消息转换器类类型
     * @return 返回true则会执行beforeBodyRead
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return methodParameter.hasMethodAnnotation(Decrypt.class) || methodParameter.hasParameterAnnotation(Decrypt.class);
    }

    /**
     * 在Http消息转换器执转换，之前执行
     *
     * @return 返回 一个自定义的HttpInputMessage
     */
    @Override
    public HttpInputMessage beforeBodyRead(final HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) throws IOException {
        byte[] body = new byte[inputMessage.getBody().available()];
        inputMessage.getBody().read(body);
        try {
            byte[] keyBytes = keyProperties.getKey().getBytes();
            byte[] decrypt = AESUtils.decrypt(body, keyBytes);
            final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(decrypt);
            return new HttpInputMessage() {
                @Override
                public InputStream getBody() {
                    return byteArrayInputStream;
                }

                @Override
                public HttpHeaders getHeaders() {
                    return inputMessage.getHeaders();
                }
            };
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.beforeBodyRead(inputMessage, parameter, targetType, converterType);
    }
}
