package spring5source.b.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "mymvc.servlet")
public class B2Properties {
    private Integer loadOnStartup;
    private String path;
}
