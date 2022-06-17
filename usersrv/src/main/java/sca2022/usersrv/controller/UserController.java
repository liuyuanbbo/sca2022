package sca2022.usersrv.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    final Map<Integer, String> userMap = Map.of(1001, "张三", 1002, "李四", 1003, "王五");

    @GetMapping("/get/{userId}")
    public String getUser(@PathVariable Integer userId) {
        return userMap.getOrDefault(userId, "张三");
    }
}
