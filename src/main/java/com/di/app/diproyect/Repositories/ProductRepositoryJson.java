package com.di.app.diproyect.Repositories;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.di.app.diproyect.Models.Product;
import com.fasterxml.jackson.databind.ObjectMapper; //nos permite construir un file a un objeto de java


public class ProductRepositoryJson implements IProductRepository{

    private List<Product> productList;


    public ProductRepositoryJson(){
        Resource resource = new ClassPathResource("product.json");
        ObjectMapper obj= new ObjectMapper();
        try {
            productList = Arrays.asList(obj.readValue(resource.getInputStream(), Product[].class));
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> FindAll() {
        return productList;
    }

    @Override
    public Product FindById(Long i) {
        return productList.stream().filter(p->{
            return p.getId().equals(i);
        }).findFirst().orElseThrow();
    }

}
