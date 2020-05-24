package com.kendo.scope;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BeanScopeCaseTests {

    @Autowired
    private SingleTaskService taskService;

    @Test
    public void singleDependentPrototypeCaseTest() throws InterruptedException {
        taskService.execute();
        Thread.sleep(Integer.MAX_VALUE);
    }
}
