package com.kendo.instantiation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author kendone
 */
public class InstantiationMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
        User user = (User) applicationContext.getBean("user");
        System.out.println(user);
    }

}
