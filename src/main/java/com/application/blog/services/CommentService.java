package com.application.blog.services;

import com.application.blog.payloads.CommentDto;
import java.util.List;

public interface CommentService {

    CommentDto createComment(CommentDto commentDto, Integer postId, Integer userId);
    void deleteComment(Integer commentId);

    // Get all Comments made by User
    List<CommentDto> getCommentsByUser(Integer userId);

    // Update User Comment
    CommentDto updateUserComment(CommentDto commentDto, Integer commentId, Integer userId);
}