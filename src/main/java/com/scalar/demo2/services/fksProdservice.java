package com.scalar.demo2.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.scalar.demo2.models.Product;
import com.scalar.demo2.dto.fksProdDTO;

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

    @Override
    public Product CreateProduct(String title, Long id , String  categoru , Double price) {
        fksProdDTO fkpsDTO  = new fksProdDTO();
        fkpsDTO.setTitle(title);
        fkpsDTO.setId(id);
        fkpsDTO.setCategory(categoru);
        fkpsDTO.setPrice(price);
        fksProdDTO responds = rt.postForObject("https://fakestoreapi.com/products",fkpsDTO,fksProdDTO.class);
        return responds.toProduct();
    }
}


