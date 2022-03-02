package com.sulimann.springpostgresqldocker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sulimann.springpostgresqldocker.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
