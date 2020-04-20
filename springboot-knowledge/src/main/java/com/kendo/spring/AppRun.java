package com.kendo.spring;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author kendone
 */
public class AppRun {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
//        context.getEnvironment().setActiveProfiles();
//        context.register(Config.class);
//        context.refresh();
        User user = (User) context.getBean("user");
        user.helloExecute();
    }

}
