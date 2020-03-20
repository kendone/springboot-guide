package com.kendo.repositories;

import com.kendo.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author kendone
 */
public interface PostRepository extends JpaRepository<Post, Integer> {
}
