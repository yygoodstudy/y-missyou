package com.yy.ymissyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com")
public class YMissyouApplication {

    public static void main(String[] args) {
        SpringApplication.run(YMissyouApplication.class, args);
    }

}
