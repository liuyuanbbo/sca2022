package toolstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import toolstudy.properties.KeyProperties;

@SpringBootApplication
@EnableConfigurationProperties({KeyProperties.class})
public class ToolStudyApp9502 {
    public static void main(String[] args) {
        SpringApplication.run(ToolStudyApp9502.class, args);
    }
}
