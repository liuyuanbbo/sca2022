package spring5source.ch01.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring5source.b.auto.prop.MinProperties;

@SpringBootTest
@Slf4j
public class PropConfigTest {
    @Autowired
    private MinProperties minProperties;

    @Test
    public void testMinProp() {
        log.info("{}", minProperties);
    }
}
