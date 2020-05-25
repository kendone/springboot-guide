package com.kendo;

import com.kendo.plugin.SqlPrintInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author kendone
 */
@SpringBootApplication
@MapperScan("com.kendo.mapper")
public class SpringBootMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMybatisApplication.class, args);
    }

    /**
     * 注册输出 sql 语句拦截器
     *
     * @return PrintSqlInterceptor
     */
    @Bean
    public Interceptor printSqlInterceptor() {
        return new SqlPrintInterceptor();
    }
}
