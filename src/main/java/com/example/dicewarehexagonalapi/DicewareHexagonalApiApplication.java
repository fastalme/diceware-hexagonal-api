package com.example.dicewarehexagonalapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients (basePackages = "com.example")
public class DicewareHexagonalApiApplication {

    public static void main (String[] args) {
        SpringApplication.run (DicewareHexagonalApiApplication.class, args);
    }

}
