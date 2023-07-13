package com.application.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.blog.exceptions.ResourceNotFoundException;
import com.application.blog.models.Category;
import com.application.blog.payloads.CategoryDto;
import com.application.blog.repositories.CategoryRepo;
import com.application.blog.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category cat = this.modelMapper.map(categoryDto, Category.class);
        Category added = this.categoryRepo.save(cat);

        return this.modelMapper.map(added, CategoryDto.class);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {

        Category cat = this.categoryRepo.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "CategoryId", categoryId));
        cat.setCategoryDescription(categoryDto.getCategoryDescription());
        cat.setCategoryTitle(categoryDto.getCategoryTitle());

        return this.modelMapper.map(this.categoryRepo.save(cat), CategoryDto.class);

    }

    @Override
    public CategoryDto getCategory(Integer categoryId) {
        Category cat = this.categoryRepo.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "CategoryId", categoryId));
        return this.modelMapper.map(cat, CategoryDto.class);
    }

    @Override
    public List<CategoryDto> getAllCategory() {
        List<Category> categories = this.categoryRepo.findAll();
        List<CategoryDto> catDto = categories.stream().map((cat) -> modelMapper.map(cat, CategoryDto.class))
                .collect(Collectors.toList());

        return catDto;
    }

    @Override
    public void deleteCategory(Integer categoryId) {
        Category cat = this.categoryRepo.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Categoiry", "CategoryId", categoryId));
        this.categoryRepo.delete(cat);
    }

}
