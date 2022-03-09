package com.sulimann.springpostgresqldocker.services;

import java.util.List;
import java.util.Optional;

import com.sulimann.springpostgresqldocker.models.Product;
import com.sulimann.springpostgresqldocker.repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository repository;

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product findById(Long id){
        Optional<Product> obj = repository.findById(id);
        return obj.get();
    }
}
