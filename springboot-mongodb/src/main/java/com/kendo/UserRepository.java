package com.kendo;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author kendone
 */
public interface UserRepository extends MongoRepository<User, Integer> {
    List<User> findByName();
}
