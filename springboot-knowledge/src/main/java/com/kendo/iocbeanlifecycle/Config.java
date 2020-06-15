package com.kendo.iocbeanlifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author kendone
 */
@Configuration
@ComponentScan(basePackages = {"com.kendo.iocbeanlifecycle"})
public class Config {

    @Bean(initMethod = "initCar")
    public Car car() {
        Car car = new Car();
        car.setName("Ford");
        car.setSpeed(100.00f);
        return car;
    }
}
