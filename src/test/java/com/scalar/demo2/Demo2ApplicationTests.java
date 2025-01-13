package com.scalar.demo2;

import com.scalar.demo2.models.Category;
import com.scalar.demo2.models.Product;
import com.scalar.demo2.repos.categoryRepo;
import com.scalar.demo2.repos.projections.ProductProjecton;
import com.scalar.demo2.repos.projections.ProductRepo;
import org.aspectj.weaver.patterns.TypeCategoryTypePattern;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class Demo2ApplicationTests {
    @Autowired
    private categoryRepo catRepo;

    @Autowired
    private ProductRepo repo;


    @Test
    void contextLoads() {

    }
    @Test
    void demo2() {
        List<ProductProjecton> getproductbyCat = repo.getProdByCatUsingProjection(1L);
        System.out.println(getproductbyCat.get(0));
    }
    @Test
    void demo3() {
        List<Product> getproductbyCat = repo.getProdByCat(1L);
        System.out.println(getproductbyCat.get(0).toString());
    }

    @Test
    void demo4() {
        Category cat = catRepo.findById(1L).get();

        System.out.println("hi");
        List<Product> getproductbyCat = cat.getProducts();
        for (Product p : getproductbyCat) {
            System.out.println(p.toString());
        }

        
    }

}
