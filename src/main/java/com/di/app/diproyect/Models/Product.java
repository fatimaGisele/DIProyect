package com.di.app.diproyect.Models;

public class Product implements Cloneable{
    private Long id;
    private String name;
    private Long price;

    public Product(){}

    public Product(Long id, String name, Long price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getPrice() {
        return price;
    }

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (Exception e) {
            return new Product(id, name, price);
        }
       
    }
    
}
