package sca2022.usersrv.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/user")
@Slf4j
@RefreshScope
public class UserController {

    @Value("${teststr}")
    String teststr;

    final Map<Integer, String> userMap = Map.of(1001, "张三", 1002, "李四", 1003, "王五");

    @GetMapping("/get/{userId}")
    public String getUser(@PathVariable Integer userId) {
        log.info("{}", teststr);
        return userMap.getOrDefault(userId, "张三");
    }
}
