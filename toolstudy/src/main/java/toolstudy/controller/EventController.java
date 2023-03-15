package toolstudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import toolstudy.common.R;
import toolstudy.event.EmailEventPublisher;

import java.util.Map;

@RestController
@RequestMapping("/event")
public class EventController {

    @Autowired
    EmailEventPublisher emailEventPublisher;

    @PostMapping("/email")
    public R<String> emailEvent(@RequestBody Map<String, String> map) {
        String email = map.get("email");
        String res = emailEventPublisher.emailEvent(email);
        return R.ok(res);
    }

}
