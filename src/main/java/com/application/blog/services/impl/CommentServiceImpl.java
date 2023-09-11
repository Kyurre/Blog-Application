package com.application.blog.services.impl;

import com.application.blog.exceptions.ResourceNotFoundException;
import com.application.blog.models.Comment;
import com.application.blog.models.Post;
import com.application.blog.models.User;
import com.application.blog.payloads.CommentDto;
import com.application.blog.repositories.CommentRepo;
import com.application.blog.repositories.PostRepo;
import com.application.blog.repositories.UserRepo;
import com.application.blog.services.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private CommentRepo commentRepo;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * @param commentDto
     * @param postId
     * @param userId
     * @return CommentDto
     */
    @Override
    public CommentDto createComment(CommentDto commentDto, Integer postId, Integer userId) {
        User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "UserId", userId));
        Post post = this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post", "Post ID", postId));
        Comment comment = this.modelMapper.map(commentDto, Comment.class);
        comment.setPost(post);
        Comment savedComment = this.commentRepo.save(comment);
        return this.modelMapper.map(savedComment, CommentDto.class);
    }

    @Override
    public void deleteComment(Integer commentId) {

        Comment com = this.commentRepo.findById(commentId).orElseThrow(()-> new ResourceNotFoundException("Comment", "Comment ID", commentId));
        this.commentRepo.delete(com);
    }

    /**
     * @param userId
     * @return ArrayList
     */
    @Override
    public List<CommentDto> getCommentsByUser(Integer userId) {
        User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "UserID", userId));

        List<Comment> comments = this.commentRepo.findByUser(user);

        // Convert to CommentDto
        List<CommentDto> commentDtoList = comments.stream().map((comment)->this.modelMapper.map(comment, CommentDto.class)).collect(Collectors.toList());

        return commentDtoList;
    }

    /**
     * @param commentDto
     * @param commentId
     * @param userId
     * @return CommentDto
     */
    @Override
    public CommentDto updateUserComment(CommentDto commentDto, Integer commentId, Integer userId) {
        return null;
    }
}