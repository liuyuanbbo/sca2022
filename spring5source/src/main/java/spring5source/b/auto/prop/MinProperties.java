package spring5source.b.auto.prop;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ToString
@PropertySource(value = {"classpath:b/min.properties"},encoding = "UTF-8")
@ConfigurationProperties(prefix = "min")
@Component
public class MinProperties {
    private String bucketId;
    private String bucketName;
    private String accessKey;
    private String accessSecret;
}
