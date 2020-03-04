package com.kendo.repositories;

import com.kendo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author kendone
 */
public interface UserRepository extends JpaRepository<User, Integer> {
}
