package com.scalar.demo2.controllers;

import com.scalar.demo2.models.Products;
import org.springframework.web.bind.annotation.*;

@RestController
public class productController {
    @RequestMapping(value = "/product",method = RequestMethod.POST)
    public void cretaeProduct(Products products){

    }

    @GetMapping(value = "/product")
    public Products getProducts(){
        return null;

    }
    @DeleteMapping( value = "/product")
    public void deleteProduct(Products products){

    }
    @PutMapping( value = "/Product")
    public void updateProduct(Products products){

    }
}
