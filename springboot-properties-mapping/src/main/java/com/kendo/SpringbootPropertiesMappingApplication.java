package com.kendo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kendone
 */
@SpringBootApplication
@RestController
@EnableConfigurationProperties(User.class)
public class SpringbootPropertiesMappingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootPropertiesMappingApplication.class, args);
    }

    @Autowired
    private User user;

    @RequestMapping("/")
    public User userInfo() {
        return user;
    }

}
