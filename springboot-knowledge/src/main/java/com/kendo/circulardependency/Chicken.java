package com.kendo.circulardependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author kendone
 */
@Component
public class Chicken {

    @Autowired
    private Egg egg;

    public Chicken() {
        System.out.println("No egg no chicken");
    }

    public Chicken(Egg egg) {
        this.egg = egg;
    }

    @PostConstruct
    public void init() {
        egg.setChicken(this);
    }

    public Egg getEgg() {
        return egg;
    }

    public void setEgg(Egg egg) {
        this.egg = egg;
    }
}
