package sca2022.eurekasrv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaSrv9961 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaSrv9961.class, args);
    }
}
