package com.kendo.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

/**
 * @author kendone
 */
public class DatabaseTypeCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata metadata) {
        Map<String, Object> attributes = metadata.getAnnotationAttributes(DatabaseType.class.getName());
        if (attributes != null) {
            String enabledType = System.getProperty("dbType");
            String dbType = (String) attributes.get("value");
            return enabledType.equalsIgnoreCase(dbType);
        } else {
            return false;
        }
    }
}
