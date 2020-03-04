package com.kendo;

import java.util.Arrays;
import java.util.List;


/**
 * @author kendone
 */
public class MongoUserDao implements UserDao {

    @Override
    public List<String> getAllNames() {
        System.out.println("从MongoDB中获取用户信息");
        return Arrays.asList("Jordan", "Curry", "Harden");
    }
}
