package com.kendo.service;

import com.kendo.domain.User;
import com.kendo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author kendone
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserWithoutTransaction(Integer id) {
        System.out.println(userMapper.get(1));
        return userMapper.get(id);
    }

    @Override
    @Transactional
    public User getUserWithTransaction(Integer id) {
        System.out.println(userMapper.get(id));
        return userMapper.get(id);
    }

}
