package com.scalar.demo2.controllers;

import com.scalar.demo2.dto.ErrorDTO;
import com.scalar.demo2.exceptions.prodNotFoundException;
import com.scalar.demo2.models.Product;
import com.scalar.demo2.services.ProductServices;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
public class SelfProductController {
    @Qualifier("selfProdService")
    private ProductServices ps;


    public SelfProductController(@Qualifier("selfProdService")ProductServices ps) {
        this.ps = ps;
    }



    @GetMapping(value = "/self-product/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") long id) throws prodNotFoundException {
        ResponseEntity<Product> responds = new ResponseEntity<>(ps.getSingleProduct(id), HttpStatus.OK);

        return responds;

    }
    @ExceptionHandler(prodNotFoundException.class)
    public ResponseEntity<ErrorDTO> prodNotFoundExceptionHandler (Exception e){
        ErrorDTO errorDTO = new ErrorDTO();
        ResponseEntity<ErrorDTO> responds = new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
        return responds;
    }
    @PostMapping(value = "/self-product/")
    public Product PostProduct(@RequestBody Product product){
        Product p = ps.CreateProduct(product.getTitle(),product.getId(),product.getCategory().getCatName(), product.getPrice());
        return p;
    }
    @GetMapping(value = "/self-products")
    public ResponseEntity<Product[]> getAllProducts() {
        ResponseEntity<Product[]> responds = new ResponseEntity<>(ps.getAllProducts(), HttpStatus.OK);
        return responds;

    }



}

