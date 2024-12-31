package com.di.app.diproyect.Service;

import java.util.List;

import com.di.app.diproyect.Models.Product;

public interface IProductService {

    List<Product> FindAll();
    Product FindById(Long i);

}
