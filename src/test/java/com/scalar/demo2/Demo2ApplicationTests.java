package com.scalar.demo2;

import com.scalar.demo2.repos.projections.ProductProjecton;
import com.scalar.demo2.repos.projections.ProductRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Demo2ApplicationTests {
    @Autowired
    private ProductRepo repo;
    @Test
    void contextLoads() {

    }
    @Test
    void demo2() {
        List<ProductProjecton> getproductbyCat = repo.getProdByCatUsingProjection(1L);
        System.out.println(getproductbyCat.get(0).getTitle());
    }

}
