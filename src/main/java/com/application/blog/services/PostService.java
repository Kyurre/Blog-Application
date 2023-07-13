package com.application.blog.services;

import com.application.blog.models.Post;
import com.application.blog.payloads.PostDto;

import java.util.List;

public interface PostService {

    // create post
    PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

    // delete
    void deletePost(Integer postId);

    // update post
    PostDto updatePost(PostDto postDto, Integer postId);

    // Get all post
    List<PostDto> getAllPost();

    // Get post by post id
    PostDto getPostById(Integer postId);

    // Get post by a category
    List<PostDto> getPostsByCategory(Integer categoryId);

    // Get all post by user
    List<PostDto> getPostsByUser(Integer userId);


}
