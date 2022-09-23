package toolstudy.adapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import toolstudy.anno.Encrypt;
import toolstudy.common.R;
import toolstudy.properties.KeyProperties;
import toolstudy.utils.AESUtils;

@EnableConfigurationProperties(KeyProperties.class)
@ControllerAdvice
public class EncryptResponse implements ResponseBodyAdvice<R<String>> {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private KeyProperties keyProperties;

    /**
     * 该方法用于判断当前请求的返回值，是否要执行beforeBodyWrite方法
     *
     * @param methodParameter handler方法的参数对象
     * @param converterType   将会使用到的Http消息转换器类类型
     * @return 返回true则会执行beforeBodyWrite
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> converterType) {
        return methodParameter.hasMethodAnnotation(Encrypt.class);
    }

    /**
     * 在Http消息转换器执转换，之前执行
     *
     * @return 返回 一个自定义的HttpInputMessage，可以为null，表示没有任何响应
     */
    @Override
    public R<String> beforeBodyWrite(R<String> body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        byte[] keyBytes = keyProperties.getKey().getBytes();
        try {
            if (body.getMsg() != null) {
                body.setMsg(AESUtils.encrypt(body.getMsg().getBytes(), keyBytes));
            }
            if (body.getData() != null) {
                body.setData(AESUtils.encrypt(objectMapper.writeValueAsBytes(body.getData()), keyBytes));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return body;
    }
}
