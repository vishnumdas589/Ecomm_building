package com.scalar.demo2.services;

import com.scalar.demo2.exceptions.prodNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import com.scalar.demo2.models.Product;

import java.util.List;

@Service
public interface ProductServices {
     Product getSingleProduct(long id) throws prodNotFoundException;
     Product CreateProduct(String title,Long Id, String  category, Double price);
     Page<Product> getAllProducts(int pageNumber, int pageSize,String fieldName);
     Product updateSingleProduct(Long id,String title,Double price, String  category) throws prodNotFoundException;
     String deleteSingleProduct(Long id) throws prodNotFoundException;
}
