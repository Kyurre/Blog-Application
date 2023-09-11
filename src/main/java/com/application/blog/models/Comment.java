package com.application.blog.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "comments")
@Getter
@Setter
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String content;


    // Post comment
    @ManyToOne
    private Post post;

    // Comments by user
    @ManyToOne
    private User user;
}