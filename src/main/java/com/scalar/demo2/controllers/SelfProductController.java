 package com.scalar.demo2.controllers;

import com.scalar.demo2.dto.ErrorDTO;
import com.scalar.demo2.exceptions.prodNotFoundException;
import com.scalar.demo2.models.Product;
import com.scalar.demo2.services.ProductServices;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
public class SelfProductController {

    private ProductServices ps;

    public SelfProductController( @Qualifier("selfProdService")ProductServices ps) {
        this.ps = ps;
    }



    @GetMapping(value = "/self-product/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") long id) throws prodNotFoundException {
        ResponseEntity<Product> responds = new ResponseEntity<>(ps.getSingleProduct(id), HttpStatus.OK);

        return responds;

    }

    @PostMapping(value = "/self-product/")
    public Product PostProduct(@RequestBody Product product){
        Product p = ps.CreateProduct(product.getTitle(),product.getId(),product.getCategory().getCatName(), product.getPrice());
        return p;
    }
//    @GetMapping(value = "/self-products")
//    public ResponseEntity<Product[]> getAllProducts() {
//        ResponseEntity<Product[]> responds = new ResponseEntity<>(ps.getAllProducts(), HttpStatus.OK);
//        return responds;
//
//    }
    @GetMapping(value = "/self-products")
    public Page<Product> getAllProducts(@RequestParam("pageNumber") int pageNumber, @RequestParam("pageSize") int pageSize, @RequestParam("fieldName") String fieldName) throws prodNotFoundException {
        Page<Product> responds = ps.getAllProducts(pageNumber,pageSize,fieldName);
        return responds;

    }

    @PatchMapping(value = "/self-product/{id}")
    public ResponseEntity<Product> updateSingleProduct(@PathVariable("id") long id,@RequestBody Product product) throws prodNotFoundException {
        ResponseEntity<Product> responds = new ResponseEntity<>(ps.updateSingleProduct(id ,product.getTitle(),product.getPrice(),product.getCategory().getCatName()), HttpStatus.OK);
        return responds;
    }

    @DeleteMapping(value= "/delete-self-product/{id}")
    public ResponseEntity<String> deleteSingleProduct(@PathVariable("id") long id) throws prodNotFoundException {
        ResponseEntity<String> response = new ResponseEntity<>(ps.deleteSingleProduct(id),HttpStatus.OK);
        return response;
    }



}

