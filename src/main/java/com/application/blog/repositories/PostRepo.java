package com.application.blog.repositories;

import com.application.blog.models.Category;
import com.application.blog.models.Post;
import com.application.blog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post,Integer> {

    List<Post> findByUser (User user);
    List<Post> findByCategory(Category category);

    List<Post> findByTitleContaining(String title);


    /* Alternate way of doing it with Query
    @Query(select p from Post p where p.title like :key")
    List<Post>searchByTitle(@Param("key") String title);
    -> See other changes made in PostServiceImpl for the search post method
     */
}
