package com.kendo;

import com.kendo.domain.User;
import com.kendo.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SpringbootJpaApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findAllUsers() {
        List<User> users = userRepository.findAll();
        assertTrue(users.size() > 0);
    }

    @Test
    public void findUserById() {
        Optional<User> user = userRepository.findById(1);
        assertNotNull(user.get());
    }
}
