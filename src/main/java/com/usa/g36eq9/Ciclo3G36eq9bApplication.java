package com.usa.g36eq9;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
public class Ciclo3G36eq9bApplication {

    public static void main(String[] args) {
        SpringApplication.run(Ciclo3G36eq9bApplication.class, args);
    }

}
