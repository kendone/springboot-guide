package com.kendo;

import com.kendo.domain.User;
import com.kendo.mapper.AnnotatedUserMapper;
import com.kendo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author kendone
 */
@SpringBootTest
public class SpringBootMybatisApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AnnotatedUserMapper annotatedUserMapper;

    @Test
    public void insertUser() {
        User user = new User();
        user.setName("霍华德");
        user.setEmail("Howord@163.com");
        annotatedUserMapper.insert(user);
    }

    @Test
    public void findAllUsers() {
        List<User> users = userMapper.findAll();
        assertNotNull(users);
        assertFalse(users.isEmpty());
    }

    @Test
    public void findAllUsersUsingAnnotatedUserMapper() {
        List<User> users = annotatedUserMapper.findAll();
        assertNotNull(users);
        assertFalse(users.isEmpty());
    }

}
