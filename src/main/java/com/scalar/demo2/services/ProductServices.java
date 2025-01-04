package com.scalar.demo2.services;

import com.scalar.demo2.exceptions.prodNotFoundException;
import org.springframework.stereotype.Service;
import com.scalar.demo2.models.Product;

import java.util.List;

@Service
public interface ProductServices {
     Product getSingleProduct(long id) throws prodNotFoundException;
     Product CreateProduct(String title, Long id , String  category, Double price);
     Product [] getAllProducts();


}
