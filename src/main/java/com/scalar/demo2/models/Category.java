package com.scalar.demo2.models;

public class Category {
    private Long catId;
    private String catName;

    public Category() {
    }

    public Category(Long catId, String catName) {
        this.catId = catId;
        this.catName = catName;
    }

    public Long getCatId() {
        return catId;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatId(Long catId) {
        this.catId = catId;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }
}
