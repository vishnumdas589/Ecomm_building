package com.scalar.demo2.services;
import com.scalar.demo2.exceptions.prodNotFoundException;
import com.scalar.demo2.models.Category;
import com.scalar.demo2.models.Product;
import com.scalar.demo2.repos.categoryRepo;
import com.scalar.demo2.repos.*;
import com.scalar.demo2.repos.projections.ProductRepo;
import org.springframework.stereotype.Service;

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
    public Product[] getAllProducts() {
        return new Product[0];
    }

}
