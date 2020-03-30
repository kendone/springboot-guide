package com.kendo.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * @author kendone
 */
@Configuration
public class Config {

    @Lazy
    @Bean
    public User user() {
        return new User();
    }
}
