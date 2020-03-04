package com.kendo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;

/**
 * 使用 -DdbType=mysql 的VM选项后启动
 *
 * @author kendone
 */
@SpringBootApplication
public class SpringBootKnowledgeApplication {

    private static final Logger LOG = LoggerFactory.getLogger(SpringBootKnowledgeApplication.class.getName());

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .bannerMode(Banner.Mode.OFF)
                .sources(SpringBootKnowledgeApplication.class)
                .run(args);
    }

    @Bean
    @Conditional(MySqlDBTypeCondition.class)
    public UserDao jdbcUserDao() {
        if (LOG.isInfoEnabled()) {
            LOG.info("使用了MySql数据库");
        }
        return new JdbcUserDao();
    }

    @Bean
    @DatabaseType(value = "mysql")
    public UserDao jdbcUserDao1() {
        if (LOG.isInfoEnabled()) {
            LOG.info("使用了MySql数据库");
        }
        return new JdbcUserDao();
    }


    @Bean
    @Conditional(MongoDBTypeCondition.class)
    public UserDao mongoUserDao() {
        if (LOG.isInfoEnabled()) {
            LOG.info("使用了MongoDB数据库");
        }
        return new MongoUserDao();
    }

    @Bean
    @DatabaseType(value = "mongo")
    public UserDao mongoUserDao1() {
        if (LOG.isInfoEnabled()) {
            LOG.info("使用了MongoDB数据库");
        }
        return new MongoUserDao();
    }
}
