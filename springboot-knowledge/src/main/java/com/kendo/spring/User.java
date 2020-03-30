package com.kendo.spring;

/**
 * @author kendone
 */
public class User {

    static {
        System.out.println("执行 User 的静态初始化");
    }

    public User() {
        System.out.println("执行 User 初始化");
    }
}
