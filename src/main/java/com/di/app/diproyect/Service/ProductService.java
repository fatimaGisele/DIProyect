package com.di.app.diproyect.Service;

import java.util.List;
import java.util.stream.Collectors;

import com.di.app.diproyect.Models.Product;
import com.di.app.diproyect.Repositories.ProductRepository;


public class ProductService { //trabaja los datos

    private ProductRepository repository= new ProductRepository();

    public List<Product> FindAll(){
        return repository.FindAll().stream().map(p->{
            Double imp = p.getPrice()*1.21d; //se crea una nueva instancia de producto y se lo duvuelve, no modifica al original, ni aun ante 
            Product nProduct = new Product(p.getId(),p.getName(),imp.longValue()); //un nuevo llamado
            return nProduct;
        }).collect(Collectors.toList());
    }

    public Product FindById(Long i){
        return repository.FindById(i);
    }
}
