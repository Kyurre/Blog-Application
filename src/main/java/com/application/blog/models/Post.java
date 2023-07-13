package com.application.blog.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name="posts")
@Getter
@Setter
@NoArgsConstructor
public class Post {

    // Category ID
    @ManyToOne
    @JoinColumn(name="categoryId", nullable = false)
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
