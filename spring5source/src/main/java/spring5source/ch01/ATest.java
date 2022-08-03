package spring5source.ch01;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.GenericApplicationContext;

@Slf4j
public class ATest {
    public static void main(String[] args) {
        GenericApplicationContext ctx = new GenericApplicationContext();
        ctx.refresh();
        log.info("容器刷新完毕");
    }
}
