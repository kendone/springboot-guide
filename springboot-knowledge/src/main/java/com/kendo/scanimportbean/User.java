package com.kendo.scanimportbean;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author kendone
 */
public class User {

    @Value("${user.name}")
    private String name;
    @Value("${user.age}")
    private Integer age;

    static {
        System.out.println("执行 User 的静态初始代码块");
    }

    public User() {
        System.out.println("执行 User 构造方法");
    }

    public void helloExecute() {
        System.out.println("你好");
    }
}
