package spring5source.ch02;

import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import spring5source.ch02.config.WebConfig;


public class Ch02Test {

    public static void main(String[] args) {
        AnnotationConfigServletWebServerApplicationContext context =
                new AnnotationConfigServletWebServerApplicationContext(WebConfig.class);
    }
}
