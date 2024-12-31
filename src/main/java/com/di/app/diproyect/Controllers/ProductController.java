package com.di.app.diproyect.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import com.di.app.diproyect.Models.Product;
import com.di.app.diproyect.Service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService service;

    public ProductController(){}

    @GetMapping()
    public List<Product> ListProduct(){
        return service.FindAll();
   } 

   @GetMapping("/{id}")
   public Product ShowProduct(@PathVariable Long id){
        return service.FindById(id);
   }

    
}
