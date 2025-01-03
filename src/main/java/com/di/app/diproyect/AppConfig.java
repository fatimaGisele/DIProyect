package com.di.app.diproyect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import com.di.app.diproyect.Repositories.IProductRepository;
import com.di.app.diproyect.Repositories.ProductRepositoryJson;

@Configuration
@PropertySource("classpath:config.properties")
public class AppConfig {

    @Bean
    @Primary
    IProductRepository ProdRepJson(){
        return new ProductRepositoryJson();    
    }
}
