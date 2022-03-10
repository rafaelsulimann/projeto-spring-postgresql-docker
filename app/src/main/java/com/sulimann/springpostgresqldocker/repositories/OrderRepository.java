package com.sulimann.springpostgresqldocker.repositories;

import com.sulimann.springpostgresqldocker.models.Order;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
    
}
