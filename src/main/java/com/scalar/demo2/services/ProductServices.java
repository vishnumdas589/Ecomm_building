package com.scalar.demo2.services;

import org.springframework.stereotype.Service;
import com.scalar.demo2.models.Product;

@Service
public interface ProductServices {
     Product getSingleProduct(long id);
     Product CreateProduct(String title, Long id , String  category, Double price);


}
