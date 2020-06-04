package com.kendo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

/**
 * @author kendone
 */
@RedisHash
public class User {
    @Id
    @NotNull
    private String id;
    @NotNull
    @NotBlank
    private String name;
    private boolean isValid;

    public User(@NotNull @NotBlank String name, boolean isValid) {
        String temp = UUID.randomUUID().toString();
        this.id = temp;
        System.out.println("id：" + id);
        this.name = name;
        this.isValid = isValid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }
}
