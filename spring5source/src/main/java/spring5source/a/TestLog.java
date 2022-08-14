package spring5source.a;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Slf4j
public class TestLog {
    @PostConstruct
    public void init() {
        if (log.isDebugEnabled()) {
            log.debug("debug 初始化: {}", " debug ");
        }
    }
}
