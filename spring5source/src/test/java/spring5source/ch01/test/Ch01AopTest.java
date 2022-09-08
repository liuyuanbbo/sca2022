package spring5source.ch01.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import spring5source.ch01.service.IMessageService;

@ContextConfiguration(locations = {"classpath:spring/spring-ch01-aop.xml"})
@ExtendWith({SpringExtension.class})
@Slf4j
public class Ch01AopTest {

    @Autowired
    private IMessageService messageServiceImpl;

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void testEcho() {
        log.info("111 {}", applicationContext.getClass().getName());
        log.info("{}", this.messageServiceImpl.getClass().getName());
        log.info("{}", this.messageServiceImpl.echo(" 易方达科技 https://efunds.com.cn "));
    }

}
