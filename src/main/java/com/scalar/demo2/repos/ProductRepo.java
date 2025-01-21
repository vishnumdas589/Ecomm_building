package com.scalar.demo2.repos.projections;

import com.scalar.demo2.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Long> {
    Product save(Product product);
    Product findByTitle(String title);
    Product findByDescription(String description);
    Product findByPrice(Double price);

    @Override
    Page<Product> findAll(Pageable pageable);

    @Query(value = "SELECT * from Product p where p.category_id =:catID",nativeQuery = true)
    List<Product> getProdByCat(@Param("catID") Long CatID);

    @Query(value = "SELECT p.title,p.description from Product p where p.category_id =:catID",nativeQuery = true)
    List<ProductProjecton> getProdByCatUsingProjection(@Param("catID") Long CatID);



}
