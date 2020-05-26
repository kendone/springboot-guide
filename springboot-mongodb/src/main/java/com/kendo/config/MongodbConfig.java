package com.kendo.config;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.env.Environment;

/**
 * MongoDB Embedded server 配置
 *
 * @author kendone
 */
@Configuration
public class MongodbConfig {

    private Environment environment;

    public MongodbConfig(Environment environment) {
        this.environment = environment;
    }

    @Bean
    @DependsOn("embeddedMongoServer")
    public com.mongodb.MongoClient mongoClient() {
        int port = this.environment.getProperty("local.mongo.port", Integer.class);
        return new MongoClient("localhost", port);
    }
}
