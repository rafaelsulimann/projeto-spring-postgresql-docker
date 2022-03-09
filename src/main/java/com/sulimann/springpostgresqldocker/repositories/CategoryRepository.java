package com.sulimann.springpostgresqldocker.repositories;

import com.sulimann.springpostgresqldocker.models.Category;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    
}
