package toolstudy.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class EmailEventPublisher {

    @Autowired
    ApplicationEventPublisher publisher;

    public String emailEvent(String email) {
        publisher.publishEvent(new EmailEvent(email));
        return email;
    }


}
