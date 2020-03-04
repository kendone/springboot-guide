package com.kendo;

import java.util.Arrays;
import java.util.List;

/**
 * @author kedone
 */
public class JdbcUserDao implements UserDao {
    @Override
    public List<String> getAllNames() {
        System.out.println("从数据库中获取信息");
        return Arrays.asList("Jordan", "Curry", "Harden");
    }
}
