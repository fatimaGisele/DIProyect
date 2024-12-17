package com.di.app.diproyect.Repositories;

import java.util.Arrays;
import java.util.List;

import com.di.app.diproyect.Controllers.Product;

public class ProductRepository {

    private List<Product> data;

    public ProductRepository(){
        this.data = Arrays.asList(
            new Product(1L,  "airpods",50000L),
            new Product(2L,  "aURISs",50000L),
            new Product(2L,  "teclado",30000L));
    }

    public List<Product> FindAll(){
        return this.data;
    }

    public Product FindById(Long id){
        return data.stream().filter(p->p.getId().equals(id)).findFirst().orElse(null);//si no encuentra devuelve null
        //stream procesar y manipular colecciones //orElseThrow devuelve un valor si está presente, o lanza una excepción si no lo está
    }
    
}
