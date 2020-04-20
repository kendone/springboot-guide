package com.kendo.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.*;

/**
 * @author kendone
 */
@Configuration
@EnableAspectJAutoProxy
@PropertySource(value = {"classpath:user.properties"})
@Import(value = {Car.class, KendoImportSelector.class, KendoBeanDefinitionRegister.class})
public class Config {

    private static final Logger LOG = LoggerFactory.getLogger(Config.class);

    @Bean
    public LogAspectJ logAspectJ() {
        return new LogAspectJ();
    }

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
     * 执行时机：所有的Bean定义信息已经加载到容器中，但是Bean实例还没有被初始化
     *
     * @return BeanFactoryPostProcessor
     */
    @Bean
    public static BeanFactoryPostProcessor beanFactoryPostProcessor() {
        return beanFactory -> {
            System.out.println("BeanFactoryPostProcessor->容器中Bean的个数为：" + beanFactory.getBeanDefinitionCount());
            for (String beanName : beanFactory.getBeanDefinitionNames()) {
                if ("user".equals(beanName)) {
                    BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanName);
                    // 修改user Bean 为惰性实例化
                    beanDefinition.setLazyInit(true);
                }
            }
        };
    }

    /**
     * 执行时机：所有的bean定义信息将要被加载到容器中，Bean实例还没有被初始化
     *
     * @return {@link BeanDefinitionRegistryPostProcessor}
     */
    @Bean
    public static BeanDefinitionRegistryPostProcessor beanDefinitionRegistryPostProcessor() {
        return new BeanDefinitionRegistryPostProcessor() {

            @Override
            public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
                LOG.info("BeanDefinitionRegistryPostProcessor->容器中Bean的个数为：{}", beanFactory.getBeanDefinitionCount());
            }

            @Override
            public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
                RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Car.class);
                registry.registerBeanDefinition("ford", rootBeanDefinition);
            }
        };
    }
}
