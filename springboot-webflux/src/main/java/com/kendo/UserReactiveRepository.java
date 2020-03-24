package com.kendo;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

/**
 * @author kendone
 */
public interface UserReactiveRepository extends ReactiveCrudRepository<User,String> {
}
