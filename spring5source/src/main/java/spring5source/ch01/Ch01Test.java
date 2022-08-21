package spring5source.ch01;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring5source.ch01.service.IMessageService;

@Slf4j
public class Ch01Test {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-ch01-aop.xml");
        IMessageService messageService = ctx.getBean(IMessageService.class);
        String echo = messageService.echo("hello world");
        log.info("{}", echo);
        log.info("容器刷新完毕");
    }
}
