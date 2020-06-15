package com.kendo.iocbeanlifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author kendone
 */
public class BeanLifeCycleMain {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Car car = (Car) context.getBean("car");
        System.out.println(car);
    }

}
