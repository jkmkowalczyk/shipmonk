package com.shipmonk.testingday.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class SpringConfiguration {
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
