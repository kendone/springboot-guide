package com.kendo;

import com.kendo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MybatisSqlSessionLevelCacheCaseTests {

    @Autowired
    private UserService userService;

    /**
     * 没有事务时，Mybatis一级缓存会失效
     */
    @Test
    public void testGetUserWithoutTransaction() {
        System.out.println(userService.getUserWithoutTransaction(1));
    }

    /**
     * 添加事务支持时，同一事务满足条件的查询会使用一级缓存
     */
    @Test
    public void testGetUserWithTransaction() {
        System.out.println(userService.getUserWithTransaction(1));
    }
}
