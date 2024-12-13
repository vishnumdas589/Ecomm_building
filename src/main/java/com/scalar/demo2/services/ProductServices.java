package com.scalar.demo2.services;

import org.springframework.stereotype.Service;

@Service
public interface ProductServices {
     Product getSingleProduct(long id);

}
