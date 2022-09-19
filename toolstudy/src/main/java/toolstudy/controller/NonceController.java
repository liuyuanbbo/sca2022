package toolstudy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import toolstudy.anno.AntiReply;
import toolstudy.support.SimpleResponse;

@RestController
public class NonceController {

    @GetMapping("/tst1")
    @AntiReply
    public SimpleResponse tst1() {
        SimpleResponse response = new SimpleResponse();
        response.setContent("哈哈");
        return response;
    }

}
