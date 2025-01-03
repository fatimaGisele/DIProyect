package com.di.app.diproyect.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.di.app.diproyect.Models.Product;
import com.di.app.diproyect.Repositories.IProductRepository;

@Service
public class ProductService implements IProductService{ //trabaja los datos

    @Autowired //estamos inyectando al productService de una instancia de productRepository
    private IProductRepository repository;
    @Autowired
    private Environment environment;

    public ProductService(@Qualifier("ProdRepJson") IProductRepository repository){
        this.repository = repository;
    }

    @Override
    public List<Product> FindAll(){
        return repository.FindAll().stream().map(p->{       //Double.class castea el valor a double
            Double imp = p.getPrice()*environment.getProperty("config.imp", Double.class); //se crea una nueva instancia de producto y se lo duvuelve, no modifica al original, ni aun ante 
            //Product nProduct = new Product(p.getId(),p.getName(),imp.longValue()); //un nuevo llamado
            
            Product nProduct = (Product) p.clone();
            nProduct.setPrice(imp.longValue());

            //p.setPrice(imp.longValue());
            //return p;

            return nProduct;
        }).collect(Collectors.toList());
    }

    @Override
    public Product FindById(Long i){
        return repository.FindById(i);
    }
}
