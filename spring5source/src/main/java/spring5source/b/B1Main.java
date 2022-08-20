package spring5source.b;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;

@Slf4j
public class B1Main {
    public static void main(String[] args) {
         new AnnotationConfigServletWebServerApplicationContext(B1Config.class);
    }

}
