package com.scalar.demo2.controllers;

import com.scalar.demo2.models.Product;
import org.springframework.web.bind.annotation.*;

@RestController
public class productController {
    ProductServies ps;
    public productController(ProductServies ps) {
        this.ps = ps;
    }


    @GetMapping(value = "/product/{id}")
    public Product getProduct(@PathVariable("id") long id){
        ps.getSingleProduct(id);
        return Product;

    }

}
