package sca2022.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewaySrv8080 {
    public static void main(String[] args) {
        SpringApplication.run(GatewaySrv8080.class, args);
    }
}
