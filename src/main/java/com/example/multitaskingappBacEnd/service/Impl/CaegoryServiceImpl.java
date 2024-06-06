package com.example.multitaskingappBacEnd.service.Impl;

import com.example.multitaskingappBacEnd.Pom.exam.Category;
import com.example.multitaskingappBacEnd.Repo.CategoryRepository;
import com.example.multitaskingappBacEnd.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class CaegoryServiceImpl implements CategoryService {
    
   @Autowired
    private CategoryRepository categoryRepository;
    
    @Override
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
        
    }

    @Override
    public Category updateCategory(Category category) {
        return this.categoryRepository.save(category);
    }

    @Override
    public Set<Category> getCategories() {
        return new LinkedHashSet<>(this.categoryRepository.findAll());
    }

    @Override
    public Category getCategory(Long categoryId) {
        return this.categoryRepository.findById(categoryId).get();
    }

    @Override
    public void deleteCategory(Long CategoryId) {
        Category category =new Category();
        category.setCid(CategoryId);
        this.categoryRepository.delete(category);

    }
}
