package com.kendo.iocbeanlifecycle;

import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;

/**
 * @author kendone
 */
public class Car implements InitializingBean {

    private String name;
    private Float speed;

    public Car() {
        System.out.println("4. 执行 Car 的构造方法");
    }

    public void initCar() {
        this.name = "黄包车";
        this.speed = 10.00f;
        System.out.println("7. 执行 Car 配置时使用 @Bean(initMethod = \"initCar\") 设置的初始化 initCar 方法");
    }

    @PostConstruct
    public void init() {
        System.out.println("5. 执行使用了 @PostConstruct注解的 init 方法");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getSpeed() {
        return speed;
    }

    public void setSpeed(Float speed) {
        this.speed = speed;
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("6. 执行 afterPropertiesSet 方法");
    }

    @Override
    public String toString() {
        return "Car {name:" + name + ", speed:" + speed + "}";
    }
}
