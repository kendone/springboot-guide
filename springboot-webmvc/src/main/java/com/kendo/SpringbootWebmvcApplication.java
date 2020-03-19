package com.kendo;

import net.bull.javamelody.MonitoringFilter;
import net.bull.javamelody.SessionListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.DispatcherType;
import java.util.Properties;

/**
 * @author kendone
 */
@SpringBootApplication
public class SpringbootWebmvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootWebmvcApplication.class, args);
    }

    /**
     * 异常处理：设置异常所对应的页面
     *
     * @return SimpleMappingExceptionResolver
     */
    @Bean
    public SimpleMappingExceptionResolver simpleMappingExceptionResolver() {
        SimpleMappingExceptionResolver exceptionResolver = new SimpleMappingExceptionResolver();
        Properties mappings = new Properties();
        mappings.setProperty("DataAccessException", "dbError");
        mappings.setProperty("RuntimeException", "error");
        exceptionResolver.setExceptionMappings(mappings);
        exceptionResolver.setDefaultErrorView("error");
        return exceptionResolver;
    }

    @Bean(name = "javamelodyFilter")
    public FilterRegistrationBean<MonitoringFilter> javamelodyFilterBean() {
        FilterRegistrationBean<MonitoringFilter> registration =
                new FilterRegistrationBean<>();
        registration.setFilter(new MonitoringFilter());
        registration.addUrlPatterns("/*");
        registration.setName("javamelodyFilter");
        registration.setAsyncSupported(true);
        registration.setDispatcherTypes(DispatcherType.REQUEST, DispatcherType.ASYNC);
        return registration;
    }

    @Bean(name = "javamelodySessionListener")
    public ServletListenerRegistrationBean<SessionListener> sessionListener() {
        return new ServletListenerRegistrationBean<>(new SessionListener());
    }

}
