package com.example.microserviceconsumer;

import org.flywaydb.core.Flyway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MicroServiceConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroServiceConsumerApplication.class, args);
    }

}
