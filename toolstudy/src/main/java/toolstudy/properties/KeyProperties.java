package toolstudy.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.encrypt")
@Getter
@Setter
public class KeyProperties {
    private final static String DEFAULT_KEY = "1234567890abcdef";
    private String key = DEFAULT_KEY;
}
