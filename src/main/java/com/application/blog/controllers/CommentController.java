package com.application.blog.controllers;

import com.application.blog.payloads.ApiResponse;
import com.application.blog.payloads.CommentDto;
import com.application.blog.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class CommentController {


    @Autowired
    private CommentService commentService;


    @PostMapping("/posts/{postID}/comments/{userId}")
    public ResponseEntity<CommentDto> createComment(
            @RequestBody CommentDto comment,
            @PathVariable Integer postID,
            @PathVariable Integer userId
    ){
        CommentDto createComment = this.commentService.createComment(comment, postID, userId);
        return new ResponseEntity<>(createComment, HttpStatus.CREATED);
    }

    @DeleteMapping("/comments/{commentID}")
    public ResponseEntity<ApiResponse> createComment(
            @PathVariable Integer commentID
    ){
        this.commentService.deleteComment(commentID);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Comment Deleted Successfully!", true), HttpStatus.OK);
    }

}