package com.kendo.circulardependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author kendone
 */
@Component
public class Egg {

    @Autowired
    private Chicken chicken;

    public Egg() {
        System.out.println("No chicken no egg");
    }

    public Egg(Chicken chicken) {
        this.chicken = chicken;
    }

    public Chicken getChicken() {
        return chicken;
    }

    public void setChicken(Chicken chicken) {
        this.chicken = chicken;
    }
}
