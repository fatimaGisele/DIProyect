package com.di.app.diproyect.Repositories;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
//import org.springframework.web.context.annotation.RequestScope;
//import org.springframework.web.context.annotation.SessionScope;

import com.di.app.diproyect.Models.Product;

//@RequestScope//deja de ser singleton, es por request x cliente q se comunica
//@SessionScope 
@Repository
//@Primary
public class ProductRepository implements IProductRepository{ //consulta los datos 

    private List<Product> data;

    public ProductRepository(){
        this.data = Arrays.asList(
            new Product(1L,  "airpods",50000L),
            new Product(2L,  "aURISs",50000L),
            new Product(3L,  "teclado",30000L));
    }

    @Override
    public List<Product> FindAll(){
        return this.data;
    }

    @Override
    public Product FindById(Long id){
        return data.stream().filter(p->p.getId().equals(id)).findFirst().orElse(null);//si no encuentra devuelve null
        //stream procesar y manipular colecciones //orElseThrow devuelve un valor si está presente, o lanza una excepción si no lo está
    }

   
    
}
