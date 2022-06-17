package sca2022.ordersrv.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    final RestTemplate restTemplate;

    static final String productsrvUrl = "http://localhost:9601/product/get/";
    static final String usersrvUrl = "http://localhost:9701/user/get/";

    @GetMapping("/create")
    public String createOrder(Integer userId, Integer productId) {
        String productName = restTemplate.getForObject(productsrvUrl + productId, String.class);
        String username = restTemplate.getForObject(usersrvUrl + userId, String.class);
        return "用户: " + username + " 购买了商品: " + productName;
    }

}
