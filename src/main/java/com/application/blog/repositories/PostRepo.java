package com.application.blog.repositories;

import com.application.blog.models.Category;
import com.application.blog.models.Post;
import com.application.blog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post,Integer> {

    List<Post> findByUser (User user);
    List<Post> findByCategory(Category category);

}
