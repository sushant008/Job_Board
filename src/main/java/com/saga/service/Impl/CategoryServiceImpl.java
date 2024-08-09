package com.saga.service.Impl;

import com.saga.Dto.CategoryDto;
import com.saga.Entity.Category;
import com.saga.Entity.Job;
import com.saga.Mapper.CategoryMapper;
import com.saga.Repositiory.CategoryRepository;
import com.saga.service.ICategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
 public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public void addCategory(CategoryDto categoryDto) {
        Category category= CategoryMapper.mapToCategory(new Category(),categoryDto);
        categoryRepository.save(category);
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> categories=categoryRepository.findAll();
        List<CategoryDto> categoryDtos=new ArrayList<>();
        for(Category category:categories){
            CategoryDto categoryDto=CategoryMapper.mapToCategoryDto(category,new CategoryDto());
            categoryDtos.add(categoryDto);
        }
        return categoryDtos;
    }

    @Override
    public void updateCategory(CategoryDto categoryDto ,Long id) {
        Category category= CategoryMapper.mapToCategory(new Category(),categoryDto);
        category.setId(id);

        if(categoryRepository.findById(category.getId())==null){
            throw new RuntimeException("Category Not Exist");
        }
        else {
            categoryRepository.save(category);
        }
    }

    @Override
    public boolean deleteCategory(String CategoryName) {
        Category category = categoryRepository.findByCategoryName(CategoryName)
                .orElseThrow(()->new RuntimeException("Category doesn't exist"));
        categoryRepository.deleteById(category.getId());
        return true;
    }
}
