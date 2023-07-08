package com.application.blog.models;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="posts")
public class Post {

    // Category ID
    @ManyToOne
    private Category category;

    // UserID
    @ManyToOne
    private User user;

    // PostID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;

    // Comments

    // Title
    @Column(length = 100, nullable = false)
    private String title;

    // Content
    @Column(length = 5000)
    private String content;

    // Image
    private String imageName;

    // Date the post was created
    private Date postDate;

}
