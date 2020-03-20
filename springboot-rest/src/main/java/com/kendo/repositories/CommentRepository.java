package com.kendo.repositories;

import com.kendo.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author kendone
 */
public interface CommentRepository extends JpaRepository<Comment,Integer> {
}
