package com.scalar.demo2.services;

import com.scalar.demo2.exceptions.prodNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.scalar.demo2.models.Product;
import com.scalar.demo2.dto.fksProdDTO;

import java.util.List;

@Service
public class fksProdservice implements ProductServices{

    RestTemplate rt;
    public fksProdservice(RestTemplate rt) {
        this.rt = rt;
    }



    @Override
    public Product getSingleProduct(long id)throws prodNotFoundException {
        fksProdDTO fkpsDTO = rt.getForObject("https://fakestoreapi.com/products/" + id, fksProdDTO.class);
        if(fkpsDTO == null){
            prodNotFoundException prodNotFound = new prodNotFoundException("Product with id " + id + " is not found");
            throw prodNotFound;
        }
        return fkpsDTO.toProduct();


    }
    @Override
    public Product[] getAllProducts()  {
        ResponseEntity<fksProdDTO[]> fksdto;

        fksdto  = rt.getForEntity("https://fakestoreapi.com/products", fksProdDTO[].class);
        fksProdDTO [] fksArray = fksdto.getBody();
        Product[] fksProducts = new Product[fksArray.length];
        for (int i = 0; i < fksArray.length; i++) {
            fksProducts[i] = fksArray[i].toProduct();
        }
        return fksProducts;
    }

    @Override
    public Product CreateProduct(String title, Long id , String  categoru , Double price)  {
        fksProdDTO fkpsDTO  = new fksProdDTO();
        fkpsDTO.setTitle(title);
        fkpsDTO.setId(id);
        fkpsDTO.setCategory(categoru);
        fkpsDTO.setPrice(price);
        fksProdDTO responds = rt.postForObject("https://fakestoreapi.com/products",fkpsDTO,fksProdDTO.class);
        return responds.toProduct();
    }
}


