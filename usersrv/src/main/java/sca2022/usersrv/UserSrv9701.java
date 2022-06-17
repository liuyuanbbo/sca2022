package sca2022.usersrv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class UserSrv9701 {
    public static void main(String[] args) {
        SpringApplication.run(UserSrv9701.class, args);
    }
}
