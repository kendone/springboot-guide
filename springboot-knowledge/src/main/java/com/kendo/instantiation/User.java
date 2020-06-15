package com.kendo.instantiation;

import org.springframework.stereotype.Component;

/**
 * @author kendone
 */
@Component
public class User {

    private static User user = new User();

    private User() {
    }

    public static User createUser() {
        return user;
    }

}