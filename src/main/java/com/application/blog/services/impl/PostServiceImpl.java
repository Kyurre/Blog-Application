package com.application.blog.services.impl;

import com.application.blog.exceptions.ResourceNotFoundException;
import com.application.blog.models.Category;
import com.application.blog.models.Post;
import com.application.blog.models.User;
import com.application.blog.payloads.CategoryDto;
import com.application.blog.payloads.PostDto;
import com.application.blog.repositories.CategoryRepo;
import com.application.blog.repositories.PostRepo;
import com.application.blog.repositories.UserRepo;
import com.application.blog.services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {
        User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "UserId", userId));
        Category category = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "CategoryId", categoryId));

        Post post = this.modelMapper.map(postDto, Post.class);
        post.setImageName("default.png");
        post.setPostDate(new Date());
        post.setCategory(category);
        post.setUser(user);

        Post newPost = this.postRepo.save(post);
        return this.modelMapper.map(newPost, PostDto.class);
    }

    @Override
    public void deletePost(Integer postId) {
        Post post = this.postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "PostID", postId));
        this.postRepo.delete(post);
    }

    @Override
    public PostDto updatePost(PostDto postDto, Integer postId) {
        Post post = this.postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "PostID", postId));
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());

        Post updated = this.postRepo.save(post);
        return this.modelMapper.map(updated, PostDto.class);
    }

    @Override
    public List<PostDto> getAllPost() {
        List<Post> post = this.postRepo.findAll();
        List<PostDto> postDto = post.stream().map((posts) -> this.modelMapper.map(posts, PostDto.class)).collect(Collectors.toList());
        return postDto;
    }

    @Override
    public PostDto getPostById(Integer postId) {

        Post post = this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post", "PostID", postId));
        return this.modelMapper.map(post, PostDto.class);
    }

    @Override
    public List<PostDto> getPostsByCategory(Integer categoryId) {

        Category cat = this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "CategoryId", categoryId));

        List<Post> posts = this.postRepo.findByCategory(cat);
        List<PostDto> postDtoList = posts.stream().map((post) -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());

        return postDtoList;
    }

    @Override
    public List<PostDto> getPostsByUser(Integer userId) {

        //Find user
        User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "UserID", userId));

        // Find Posts by user
        List<Post> posts = this.postRepo.findByUser(user);

        // Convert our Posts into DTO

        List<PostDto> postDtoList = posts.stream().map((post) -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());


        return postDtoList;
    }
}
