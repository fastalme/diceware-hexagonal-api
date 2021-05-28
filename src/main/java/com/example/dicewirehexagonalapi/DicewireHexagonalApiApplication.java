package com.example.dicewirehexagonalapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients (basePackages = "com.example")
public class DicewireHexagonalApiApplication {

    public static void main (String[] args) {
        SpringApplication.run (DicewireHexagonalApiApplication.class, args);
    }

}
