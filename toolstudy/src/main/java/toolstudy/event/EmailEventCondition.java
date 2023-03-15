package toolstudy.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Predicate;

@Component
public class EmailEventCondition implements Predicate<EmailEvent> {

    @Autowired
    EmailEventHandler emailEventHandler;

    @Override
    public boolean test(EmailEvent emailEvent) {
        return emailEventHandler.test(emailEvent);
    }
}
