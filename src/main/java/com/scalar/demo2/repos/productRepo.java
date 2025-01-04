package com.scalar.demo2.repos;

import com.scalar.demo2.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface productRepo extends JpaRepository<Product,Long> {
    Product save(Product product);
    Product findByTitle(String title);
    Product findByDescription(String description);
    Product findByPrice(String price);

}
