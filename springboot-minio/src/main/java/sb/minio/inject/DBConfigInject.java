package sb.minio.inject;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import sb.minio.config.DBConfig;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
@Slf4j
public class DBConfigInject {

    private final DBConfig dbConfig;

    @PostConstruct
    public void init() {
        log.info("{}", dbConfig);
    }

}
