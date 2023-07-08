package com.application.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.blog.models.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
