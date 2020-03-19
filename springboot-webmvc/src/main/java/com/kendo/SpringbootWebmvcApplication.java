package com.kendo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.Properties;

/**
 * @author kendone
 */
@SpringBootApplication
public class SpringbootWebmvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootWebmvcApplication.class, args);
    }

    @Bean
    public SimpleMappingExceptionResolver simpleMappingExceptionResolver(){
        SimpleMappingExceptionResolver exceptionResolver = new SimpleMappingExceptionResolver();
        Properties mappings = new Properties();
        mappings.setProperty("DataAccessException", "dbError");
        mappings.setProperty("RuntimeException", "error");
        exceptionResolver.setExceptionMappings(mappings);
        exceptionResolver.setDefaultErrorView("error");
        return exceptionResolver;
    }

}
