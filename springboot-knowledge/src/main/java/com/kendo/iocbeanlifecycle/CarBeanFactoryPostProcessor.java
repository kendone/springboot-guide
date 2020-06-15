package com.kendo.iocbeanlifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * @author kendone
 */
@Component
public class CarBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        RootBeanDefinition carBeanDefinition = (RootBeanDefinition) beanFactory.getBeanDefinition("car");
        System.out.println("1. "+carBeanDefinition.toString());
    }

}
