package com.kendo.circulardependency;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author kendone
 */
public class CircularDependencyMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(Config.class);
        Chicken chicken = (Chicken) annotationConfigApplicationContext.getBean("chicken");
        Egg egg = (Egg) annotationConfigApplicationContext.getBean("egg");
        System.out.println(chicken.getEgg());
        System.out.println(egg.getChicken());
    }

}
