package com.kendo.scope_issue_test;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 实现 ApplicationWare 接口，通过容器上下文确保每次调用都能获取到一个全新的多实例 Bean
 *
 * @author kendone
 */
@Component
public class SingleTaskService implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    public void execute() {
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(2);
        executor.scheduleAtFixedRate(
                applicationContext.getBean("prototypeTask", PrototypeTask.class).setName("Jordan"),
                1, 2, TimeUnit.SECONDS
        );
        executor.scheduleAtFixedRate(
                applicationContext.getBean("prototypeTask", PrototypeTask.class).setName("Durant"),
                1, 4, TimeUnit.SECONDS
        );
        /**
         * issue：
         * 如果使用 @Autowire 注入依赖作用域为 prototype 的类时无法每次执行方法行获取一个新的Bean实例
         * executor.scheduleAtFixedRate(task.setName("Durant"), 1, 2, TimeUnit.SECONDS);
         */
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
