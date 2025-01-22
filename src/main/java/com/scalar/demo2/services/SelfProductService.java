package com.scalar.demo2.services;
import com.scalar.demo2.exceptions.prodNotFoundException;
import com.scalar.demo2.models.Category;
import com.scalar.demo2.models.Product;
import com.scalar.demo2.repos.categoryRepo;
import com.scalar.demo2.repos.*;
import com.scalar.demo2.repos.projections.ProductRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProdService")
public class SelfProductService implements ProductServices{
    ProductRepo prodRepo;
    categoryRepo catRepo;
    public SelfProductService(ProductRepo prodRepo, categoryRepo catRepo) {
        this.prodRepo = prodRepo;
        this.catRepo = catRepo;
    }

    @Override
    public Product getSingleProduct(long id) throws prodNotFoundException {
        Optional<Product> prod = prodRepo.findById(id);
        if (prod.isPresent()) {
            return prod.get();
        }else{
            throw new prodNotFoundException("product not found with id " + id);
        }
    }

    @Override
    public Product CreateProduct(String title, Long id, String category, Double price) {
         Category cat = catRepo.findByCatName(category);
         Product prod = new Product();
         if(cat != null){

             prod.setCategory(cat);

         }else {
             Category newCat = new Category();
             newCat.setCatName(category);
             prod.setCategory(newCat);
             Category newSavedCat = catRepo.save(newCat);
         }
         prod.setTitle(title);
         prod.setPrice(price);
         Product newSavedProd = prodRepo.save(prod);

         return newSavedProd;
    }

    @Override
    public Page<Product> getAllProducts(int pageNumber, int pageSize, String fieldName) {
        Page<Product> productPage = prodRepo.findAll(PageRequest.of(pageNumber, pageSize, Sort.by(fieldName).ascending()));
        return productPage;
    }

//    @Override
//    public Page<Product> getAllProducts() {
//        List<Product> prodList = prodRepo.findAll();
//        Product [] prodArray = prodList.toArray(new Product[prodList.size()]);
//        return prodArray;
//    }

    @Override
    public Product updateSingleProduct(Long id, String title, Double price, String category) throws prodNotFoundException {
        Category cat = catRepo.findByCatName(category);
        Optional<Product> prodOp = prodRepo.findById(id);
        if(prodOp.isPresent()){
            if(cat == null){
                Category newCat = new Category();
                newCat.setCatName(category);
                catRepo.save(newCat);
            }
            Product p = prodOp.get();
            p.setTitle(title);
            p.setPrice(price);
            p.setCategory(cat);
            prodRepo.save(p);
            return p;

        }else {
            throw new prodNotFoundException("product not found with id " + id);
        }

    }

    @Override
    public String deleteSingleProduct(Long id) throws prodNotFoundException {
        Optional<Product> prod = prodRepo.findById(id);
        Product p;
        if(prod.isPresent()){
            p = prod.get();
            prodRepo.delete(p);
        }else{
            throw new prodNotFoundException("product not found with id " + id);
        }
        return "product with "+ id +" deleted";

    }


}
