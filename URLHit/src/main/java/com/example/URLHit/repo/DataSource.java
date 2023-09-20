package com.example.URLHit.repo;

import com.example.URLHit.model.URLHit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class DataSource {

    @Bean
    Map<String, Integer> getURLHitSource(){
        return new HashMap<>();
    }
}
