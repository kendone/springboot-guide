package com.kendo.iocbeanlifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author kendone
 */
@Component
public class CarBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("2. Process bean before initialize.");
        if (bean instanceof Car) {
            Car car = (Car) bean;
            car.setName("Audi");
            car.setSpeed(250.49f);
            return car;
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("3. Process bean after initialize.");
        return bean;
    }

}
