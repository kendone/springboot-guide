package com.kendo.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * @author kendone
 */
@Configuration
public class Config {

    private static final Logger LOG = LoggerFactory.getLogger(Config.class);

    //@Lazy
    @Bean
    public User user() {
        return new User();
    }

    @Bean
    public ApplicationListener<ApplicationEvent> applicationListener() {
        return event -> LOG.info("ApplicationListener 接受了一个事件：" + event);
    }

    /**
     * BeanFactory的后置处理器，对Bean的定义进行修改
     *
     * @return BeanFactoryPostProcessor
     */
    @Bean
    public static BeanFactoryPostProcessor beanFactoryPostProcessor() {
        return beanFactory -> {
            System.out.println("容器中Bean的个数为：" + beanFactory.getBeanDefinitionCount());
            for (String beanName : beanFactory.getBeanDefinitionNames()) {
                if ("user".equals(beanName)) {
                    BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanName);
                    // 修改user Bean 为惰性实例化
                    beanDefinition.setLazyInit(true);
                }
            }
        };
    }
}
