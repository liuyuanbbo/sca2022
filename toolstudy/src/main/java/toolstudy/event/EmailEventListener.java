package toolstudy.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@EnableAsync
public class EmailEventListener {

    @Async
    @EventListener(value = EmailEvent.class, condition = "@emailEventCondition.test(#emailEvent)")
    public void listenEmailEvent(EmailEvent emailEvent) {
        log.info("{}", emailEvent);
    }

}
