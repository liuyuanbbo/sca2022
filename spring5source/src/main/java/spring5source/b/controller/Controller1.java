package spring5source.b.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import spring5source.b.anno.Token;
import spring5source.b.anno.Yml;
import spring5source.b.pojo.BUser;

@Controller
@Slf4j
public class Controller1 {

    @GetMapping("/test1")
    public ModelAndView test1() {
        log.info("test1()");
        return null;
    }

    @PostMapping("/test2")
    public ModelAndView test2(@RequestParam String name) {
        log.info("test1【 {} 】 ", name);
        return null;
    }

    @PostMapping("/test3")
    public ModelAndView test3(@Token String token) {
        log.info("test3() ===> {}", token);
        return null;
    }

    @Yml
    @RequestMapping("/test4")
    public BUser test4() {
        log.info("test4()");
        return new BUser("bbbb", 20);
    }

}
