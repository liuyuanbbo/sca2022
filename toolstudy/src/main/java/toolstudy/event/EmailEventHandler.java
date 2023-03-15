package toolstudy.event;

import org.springframework.stereotype.Component;

@Component
public class EmailEventHandler {

    public boolean test(EmailEvent event) {
        return event.getEmail().contains("@qq");
    }

}
