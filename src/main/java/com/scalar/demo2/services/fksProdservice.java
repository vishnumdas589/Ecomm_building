package com.scalar.demo2.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class fksProdservice implements ProductServices{

    RestTemplate rt;
    public fksProdservice(RestTemplate rt) {
        this.rt = rt;
    }



    @Override
    public Product getSingleProduct(long id) {
        fksProdDTO fkpsDTO = rt.getForObject("https://fakestoreapi.com/products/" + id, fksProdDTO.class);
        return fkpsDTO.toProduct();

    }
}


