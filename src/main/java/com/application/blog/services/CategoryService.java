package com.application.blog.services;

import com.application.blog.payloads.CategoryDto;
import java.util.List;

public interface CategoryService {
    // Create
    CategoryDto createCategory(CategoryDto categoryDto);

    // Update
    CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);

    // get
    CategoryDto getCategory(Integer categoryId);

    // get all
    List<CategoryDto> getAllCategory();

    // delete
    void deleteCategory(Integer categoryId);
}
