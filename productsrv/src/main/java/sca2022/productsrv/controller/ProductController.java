package sca2022.productsrv.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/product")
public class ProductController {

    final Map<Integer, String> map = Map.of(1001, "Iphone13", 1002, "XiaoMi11", 1003, "HuaWei P60");

    @GetMapping("/get/{productId}")
    public String getProduct(@PathVariable Integer productId) {
        return map.getOrDefault(productId, "Iphone13");
    }

}
