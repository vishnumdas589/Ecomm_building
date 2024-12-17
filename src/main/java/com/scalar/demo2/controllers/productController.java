package com.scalar.demo2.controllers;
import com.scalar.demo2.services.ProductServices;
import com.scalar.demo2.models.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.scalar.demo2.services.ProductServices;
import com.scalar.demo2.services.fksProdservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
@RestController
public class productController {
    @Autowired
    @Qualifier("fksProdservice")
    private ProductServices ps;


    public productController(@Qualifier("fksProdservice")ProductServices ps) {
        this.ps = ps;
    }


    @GetMapping(value = "/product/{id}")
    public Product getProduct(@PathVariable("id") long id){
        return ps.getSingleProduct(id);

    }
    @PostMapping(value = "/product/")
    public Product PostProduct(@RequestBody Product product){
        Product p = ps.CreateProduct(product.getTitle(),product.getId(),product.getCategory().getCatName(), product.getPrice());
        return p;
    }


}
