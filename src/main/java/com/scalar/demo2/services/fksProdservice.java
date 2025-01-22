package com.scalar.demo2.services;

import com.scalar.demo2.exceptions.prodNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.scalar.demo2.models.Product;
import com.scalar.demo2.dto.fksProdDTO;

import java.util.List;

@Service("fksProdservice")
public class fksProdservice implements ProductServices{
    RedisTemplate redisTemplate;
    RestTemplate rt;
    public fksProdservice(RestTemplate rt, RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.rt = rt;
    }



    @Override
    public Product getSingleProduct(long id)throws prodNotFoundException {
        Product redisProduct = (Product)redisTemplate.opsForHash().get("Product","Product_"+ id);
        if (redisProduct != null){
            return redisProduct;
        }else{
            fksProdDTO fkpsDTO = rt.getForObject("https://fakestoreapi.com/products/" + id, fksProdDTO.class);
            if(fkpsDTO == null){
                prodNotFoundException prodNotFound = new prodNotFoundException("Product with id " + id + " is not found");
                throw prodNotFound;
            }
            redisTemplate.opsForHash().put("Product","Product_"+ id,fkpsDTO.toProduct());

            return fkpsDTO.toProduct();
            }


    }
//    @Override
//    public Product[] getAllProducts()  {
//        ResponseEntity<fksProdDTO[]> fksdto;
//
//        fksdto  = rt.getForEntity("https://fakestoreapi.com/products", fksProdDTO[].class);
//        fksProdDTO [] fksArray = fksdto.getBody();
//        Product[] fksProducts = new Product[fksArray.length];
//        for (int i = 0; i < fksArray.length; i++) {
//            fksProducts[i] = fksArray[i].toProduct();
//        }
//        return fksProducts;
//    }

    @Override
    public Product updateSingleProduct(Long id ,String title, Double price, String category) throws prodNotFoundException {
        fksProdDTO fkpsDTO = new fksProdDTO();
        fkpsDTO.setTitle(title);
        fkpsDTO.setPrice(price);
        fkpsDTO.setCategory(category);
        fksProdDTO responds = rt.patchForObject("https://fakestoreapi.com/products/" + id,fkpsDTO,fksProdDTO.class);
        return responds.toProduct();

    }

    @Override
    public String deleteSingleProduct(Long id) throws prodNotFoundException {
        return null;
    }

    @Override
    public Product CreateProduct(String title,Long Id, String  category, Double price)  {
        fksProdDTO fkpsDTO  = new fksProdDTO();
        fkpsDTO.setTitle(title);

        fkpsDTO.setCategory(category);
        fkpsDTO.setPrice(price);
        fksProdDTO responds = rt.postForObject("https://fakestoreapi.com/products",fkpsDTO,fksProdDTO.class);
        return responds.toProduct();
    }

    @Override
    public Page<Product> getAllProducts(int pageNumber, int pageSize, String fieldName) {
        return null;
    }
}


