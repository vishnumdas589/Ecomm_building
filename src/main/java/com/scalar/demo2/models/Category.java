package com.scalar.demo2.models;

import jakarta.persistence.Entity;

@Entity
public class Category extends BaseModel{

    private String catName;

    public Category() {
    }

    public Category(String catName) {
        this.catName = catName;
    }


    public String getCatName() {
        return catName;
    }


    public void setCatName(String catName) {
        this.catName = catName;
    }
}
