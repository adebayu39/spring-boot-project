package com.miniproject.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//@EnableRedisHttpSession
public class SimpleShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleShopApplication.class, args);
    }

    @Bean()
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}


