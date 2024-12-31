package com.di.app.diproyect.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.di.app.diproyect.Models.Product;
import com.di.app.diproyect.Repositories.ProductRepository;

@Component
public class ProductService implements IProductService{ //trabaja los datos

    @Autowired //estamos inyectando al productService de una instancia de productRepository
    private ProductRepository repository;

    @Override
    public List<Product> FindAll(){
        return repository.FindAll().stream().map(p->{
            Double imp = p.getPrice()*1.21d; //se crea una nueva instancia de producto y se lo duvuelve, no modifica al original, ni aun ante 
            //Product nProduct = new Product(p.getId(),p.getName(),imp.longValue()); //un nuevo llamado
            Product nProduct = (Product) p.clone();
            nProduct.setPrice(imp.longValue());
            return nProduct;
        }).collect(Collectors.toList());
    }

    @Override
    public Product FindById(Long i){
        return repository.FindById(i);
    }
}
