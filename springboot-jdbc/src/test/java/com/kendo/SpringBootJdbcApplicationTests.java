package com.kendo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class SpringBootJdbcApplicationTests {

    @Autowired
    private UserRepository userRepository;


    @Test
    public void insertUser(){
        User user = new User();
        user.setName("杜兰特");
        user.setEmail("durant@163.com");
        user = userRepository.insert(user);
        assertNotNull(user.getId());
    }

    @Test
    public void getUser(){
        User user = userRepository.get(1);
        assertNotNull(user);
    }

    @Test
    public void findAllUsers(){
        List<User> users = userRepository.findAll();
        assertNotNull(users);
        assertFalse(users.isEmpty());
        assertEquals(3,users.size());
    }
}