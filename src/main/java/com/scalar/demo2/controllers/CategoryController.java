package com.scalar.demo2.controllers;

import com.scalar.demo2.exceptions.CategoryNotFoundException;
import com.scalar.demo2.models.Category;
import com.scalar.demo2.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.net.URL;
import java.util.List;

@RestController
public class CategoryController {

    CategoryService categoryService;
    public CategoryController(@Qualifier("selfCategoryService")CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(value = "/self-category/{id}",method = RequestMethod.GET)
    public Category getCategories(@PathVariable("id") Long id) throws CategoryNotFoundException {
        return categoryService.getSingleCategory(id);
    }

    @GetMapping(value = "/All-Categories")
    public List<Category> getAllCategories() {
        return categoryService.getCategories();
    }



}
