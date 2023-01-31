package spring5source.ch02.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring5source.ch02.service.Ch02Service;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ch03")
@Slf4j
public class Ch02Controller {

    final Ch02Service ch02Service;

    @GetMapping("/test1")
    public void test1() {
        ch02Service.test1();
        log.info("{}", "test1()执行完毕");
    }

}
