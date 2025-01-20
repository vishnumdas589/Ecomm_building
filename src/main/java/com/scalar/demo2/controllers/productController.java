package com.scalar.demo2.controllers;
import com.scalar.demo2.exceptions.prodNotFoundException;
import com.scalar.demo2.services.ProductServices;
import com.scalar.demo2.models.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.scalar.demo2.services.ProductServices;
import com.scalar.demo2.services.fksProdservice;
import com.scalar.demo2.dto.ErrorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

@RestController
public class productController {
    @Qualifier("fksProdservice")
    private ProductServices ps;


    public productController(@Qualifier("fksProdservice")ProductServices ps) {
        this.ps = ps;
    }


    @GetMapping(value = "/product/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") long id) throws prodNotFoundException {
        ResponseEntity<Product> responds = new ResponseEntity<>(ps.getSingleProduct(id), HttpStatus.OK);

        return responds;

    }
    @GetMapping(value = "/products")
    public ResponseEntity<Product[]> getAllProducts() {
        ResponseEntity<Product[]> responds = new ResponseEntity<>(ps.getAllProducts(), HttpStatus.OK);
        return responds;

    }

    @PostMapping(value = "/product")
    public Product PostProduct(@RequestBody Product product){
        Product p = ps.CreateProduct(product.getTitle(),product.getId(),product.getCategory().getCatName(), product.getPrice());
        return p;
    }

    @PatchMapping(value = "/product/{id}")
    public ResponseEntity<Product> updateSingleProduct(@PathVariable("id") long id,@RequestBody Product product) throws prodNotFoundException {
        ResponseEntity<Product> responds = new ResponseEntity<>(ps.updateSingleProduct(id ,product.getTitle(),product.getPrice(),product.getCategory().getCatName()), HttpStatus.OK);
        return responds;
    }



}

