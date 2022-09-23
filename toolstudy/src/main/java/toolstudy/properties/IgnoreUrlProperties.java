package toolstudy.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@ConfigurationProperties(prefix = "ignore")
@Component
@Setter
@Getter
public class IgnoreUrlProperties {
    private List<String> urls;
}
