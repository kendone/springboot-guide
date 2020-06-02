package com.kendo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
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

    private LocalDateTime created;
    private LocalDateTime modified;
    private boolean isValid;

    public User(@NotNull String id, @NotNull @NotBlank String name, LocalDateTime created, LocalDateTime modified, boolean isValid) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.created = created;
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

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }
}
