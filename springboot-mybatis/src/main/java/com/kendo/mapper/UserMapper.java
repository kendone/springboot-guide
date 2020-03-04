package com.kendo.mapper;

import com.kendo.domain.User;

import java.util.List;

/**
 * @author kendone
 */
public interface UserMapper {
    void insert(User user);

    User get(Integer id);

    List<User> findAll();
}
