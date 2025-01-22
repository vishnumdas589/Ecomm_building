package com.scalar.demo2.repos;

import com.scalar.demo2.models.Category;
import com.scalar.demo2.models.Product;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface categoryRepo extends JpaRepository<Category, Long> {
    Category findByCatName(String catName);



}
