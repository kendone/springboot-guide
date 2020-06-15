package com.kendo.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 条件注解
 *
 * @author kendone
 */
public class MySqlDBTypeCondition implements Condition {

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata metadata) {
        //-DdbType=mysql
        String dbType = System.getProperty("dbType");
        return "mysql".equalsIgnoreCase(dbType);
    }

}
