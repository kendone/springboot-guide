package com.kendo.scope;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 多实例 Bean
 *
 * @author kendone
 */
@Component
@Scope("prototype")
public class PrototypeTask implements Runnable {

    private static final Logger LOG = LoggerFactory.getLogger(PrototypeTask.class.getName());

    private String name;

    public PrototypeTask setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public void run() {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Dad task {}`s name is {}", this, name);
        }
    }

}
