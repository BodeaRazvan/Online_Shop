package com.onlineshopping.services;

import com.onlineshopping.model.Product;
import com.onlineshopping.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<Product> findProducts(){
        return productRepository.findAll();
    }

    public Product findProductById(long id){
        return productRepository.getById((int) id);
    }
}
