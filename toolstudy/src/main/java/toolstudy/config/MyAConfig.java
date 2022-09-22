package toolstudy.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.UUID;

@ConditionalOnMissingClass({"toolstudy.config.MisingA"})
@Configuration
@Slf4j
public class MyAConfig {

    @PostConstruct
    void init() {
        log.info(">>>>>>>>>>> 初始化 {}", UUID.randomUUID());
    }
}
