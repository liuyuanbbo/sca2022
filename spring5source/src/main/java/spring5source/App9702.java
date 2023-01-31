package spring5source;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"spring5source.ch*","spring5source.b.auto*"})
public class App9702 {
    public static void main(String[] args) {
        SpringApplication.run(App9702.class, args);
    }
}
