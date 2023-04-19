package com.freundebuchag.freund;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class FreundApplication {

    public static void main(String[] args) {
        SpringApplication.run(FreundApplication.class, args);
    }

}
