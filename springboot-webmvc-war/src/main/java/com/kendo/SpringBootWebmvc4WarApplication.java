package com.kendo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kendone
 */
@SpringBootApplication
@EnableConfigurationProperties(Person.class)
@RestController
public class SpringBootWebmvc4WarApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebmvc4WarApplication.class, args);
    }

    @Autowired
    private Person person;

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SpringBootWebmvc4WarApplication.class);
    }

    @RequestMapping("/")
    public String index() {
        return "Hello Spring Boot";
    }

    @RequestMapping("/person")
    public Person getUser() {
        return person;
    }
}
