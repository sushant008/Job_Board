package com.saga.service;

import com.saga.Dto.CategoryDto;

import java.util.List;

public interface ICategoryService {
    void addCategory(CategoryDto categoryDto);

    List<CategoryDto> getAllCategories();


    void  updateCategory(CategoryDto categoryDto ,Long id);

    boolean deleteCategory(String CategoryName);
}
