package com.kendo.controller;

import com.kendo.domain.User;
import com.kendo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author kendone
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping
    public List<User> list() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User get(@PathVariable("id") Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("没有此记录"));
    }

    @PutMapping("/{id}")
    public User update(@PathVariable("id") Integer id, @RequestBody User user) throws Throwable {
        userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("没有此记录"));
        return userRepository.save(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("没有此记录"));
        userRepository.deleteById(user.getId());
    }
}
