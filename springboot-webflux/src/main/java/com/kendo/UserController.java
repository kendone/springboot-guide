package com.kendo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author kendone
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserReactiveRepository userReactiveRepository;

    @GetMapping
    public Flux<User> allUsers() {
        return userReactiveRepository.findAll();
    }

    @GetMapping("/{id}")
    public Mono<User> getUser(@PathVariable("id") String id) {
        return userReactiveRepository.findById(id);
    }

    @PostMapping
    public Mono<User> saveUser(@RequestBody Mono<User> userMono) {
        return userMono.flatMap(user -> userReactiveRepository.save(user));
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteUser(@PathVariable("id") String id) {
        return userReactiveRepository.deleteById(id);
    }
}
