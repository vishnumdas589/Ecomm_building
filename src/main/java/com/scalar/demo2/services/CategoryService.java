package com.scalar.demo2.services;
import com.scalar.demo2.exceptions.CategoryNotFoundException;
import com.scalar.demo2.models.Category;
import org.springframework.stereotype.Service;

import java.security.PublicKey;
import java.util.List;

@Service
public interface CategoryService {
    public Category getSingleCategory(Long id) throws CategoryNotFoundException;
    public List<Category> getCategories();
}
