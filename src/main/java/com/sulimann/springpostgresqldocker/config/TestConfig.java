package com.sulimann.springpostgresqldocker.config;

import java.time.Instant;
import java.util.Arrays;

import com.sulimann.springpostgresqldocker.models.Order;
import com.sulimann.springpostgresqldocker.models.User;
import com.sulimann.springpostgresqldocker.repositories.OrderRepository;
import com.sulimann.springpostgresqldocker.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456"); 
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        Order o1 = new Order(null, Instant.parse("2022-03-08T22:10:30Z"), u1);
        Order o2 = new Order(null, Instant.parse("2022-03-08T23:20:49Z"), u2);
        Order o3 = new Order(null, Instant.parse("2022-03-09T08:10:30Z"), u1);

        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
    }
    
}
