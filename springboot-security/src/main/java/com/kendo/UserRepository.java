package com.kendo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author kendone
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}
