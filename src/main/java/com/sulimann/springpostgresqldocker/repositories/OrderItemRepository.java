package com.sulimann.springpostgresqldocker.repositories;

import com.sulimann.springpostgresqldocker.models.OrderItem;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    
}
