package com.application.blog.payloads;


import com.application.blog.models.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {

    private Integer postId;
    private String title;
    private String content;
    private String imageName;
    private Date postDate;

    private UserDto user;
    private CategoryDto category;

    private List<CommentDto> comments = new ArrayList<>();
}