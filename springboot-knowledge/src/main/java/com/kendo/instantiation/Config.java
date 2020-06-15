package com.kendo.instantiation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author kendone
 */
@Configuration
@ComponentScan(basePackages = {"com.kendo.instantiation"})
public class Config {

    @Bean
    public User newUser() {
        return User.createUser();
    }

}
