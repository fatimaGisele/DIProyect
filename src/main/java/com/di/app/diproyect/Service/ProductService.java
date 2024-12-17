package com.di.app.diproyect.Service;

import java.util.List;
import java.util.stream.Collectors;

import com.di.app.diproyect.Models.Product;
import com.di.app.diproyect.Repositories.ProductRepository;


public class ProductService { //Accede a los datos atraves de los repostorios y los trabaja

    private ProductRepository repository= new ProductRepository();

    public List<Product> FindAll(){
        return repository.FindAll().stream().map(p->{
            Double imp = p.getPrice()*1.21d; 
            p.setPrice(imp.longValue());
            return p;
        }).collect(Collectors.toList());
    }

    public Product FindById(Long i){
        return repository.FindById(i);
    }
}
