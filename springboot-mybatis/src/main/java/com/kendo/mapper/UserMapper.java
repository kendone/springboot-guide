package com.kendo.mapper;

import com.kendo.domain.User;

import java.util.List;

/**
 * 基于XML和Mapper的配置
 *
 * @author kendone
 */
public interface UserMapper {

    void insert(User user);

    User get(Integer id);

    List<User> findAll();
}
