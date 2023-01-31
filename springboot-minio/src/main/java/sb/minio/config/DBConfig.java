package sb.minio.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:jdbc.properties")
@ConfigurationProperties("jdbc")
@Slf4j
@Data
public class DBConfig {

    private MyConnPool myConnPool;

    @Data
    public static class MyConnPool {
        private String driverClass;
        private String url;
        private String username;
        private String password;
    }

}
