package com.di.app.diproyect.Repositories;

import java.util.List;

import com.di.app.diproyect.Models.Product;

public interface IProductRepository {
    List<Product> FindAll();
    Product FindById(Long i);
}
