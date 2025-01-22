package com.scalar.demo2.services;

import com.scalar.demo2.exceptions.CategoryNotFoundException;
import com.scalar.demo2.models.Category;
import com.scalar.demo2.repos.categoryRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfCategoryService")
public class SelfCategoryService implements CategoryService{
    categoryRepo cateRepo;
    public SelfCategoryService(categoryRepo cateRepo) {
        this.cateRepo = cateRepo;
    }

    @Override
    public Category getSingleCategory(Long id) throws CategoryNotFoundException {
        Optional<Category> cat = cateRepo.findById(id);
        if(cat.isPresent()){
            return cat.get();
        }else{
            throw new CategoryNotFoundException("Category not found");
        }

    }

    @Override
    public List<Category> getCategories() {
        List<Category> categories = cateRepo.findAll();
        return categories;
    }
}
