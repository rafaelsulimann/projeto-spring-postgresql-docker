package com.sulimann.springpostgresqldocker.repositories;

import com.sulimann.springpostgresqldocker.models.Product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
