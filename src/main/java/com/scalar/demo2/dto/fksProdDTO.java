package com.scalar.demo2.dto;

import com.scalar.demo2.models.Category;
import com.scalar.demo2.models.Product;


// like an identical twin of product obj which is the version needed to be sent to fakestore;
public class fksProdDTO {
    private Long id;
    private String title;
    private Double price;
    private String description;
    private String Category;
    private String Image;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }


    // method to convert all the values into prodct obj format and send it to client
    public Product toProduct(){
        Product p = new Product();
        p.setId(id);
        p.setTitle(title);
        p.setPrice(price);
        p.setDescription(description);
        p.setImageUrl(Image);
        Category cat = new Category();
        cat.setCatName(Category);
        p.setCategory(cat);
        return p;
    }



}
