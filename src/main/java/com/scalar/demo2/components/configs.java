package com.scalar.demo2.components;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class configs {
    @Bean
    public RestTemplate getRest(){
        return new RestTemplate();
    }

}
