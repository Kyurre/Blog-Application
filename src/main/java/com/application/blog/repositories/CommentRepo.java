package com.application.blog.repositories;

import com.application.blog.models.Comment;
import com.application.blog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepo extends JpaRepository<Comment, Integer> {
    List<Comment> findByUser (User user);
}