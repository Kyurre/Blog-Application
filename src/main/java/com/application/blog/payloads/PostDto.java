package com.application.blog.payloads;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

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
}
