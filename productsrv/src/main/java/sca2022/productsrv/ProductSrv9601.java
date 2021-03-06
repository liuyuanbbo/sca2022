package sca2022.productsrv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProductSrv9601 {
    public static void main(String[] args) {
        SpringApplication.run(ProductSrv9601.class, args);
    }
}
