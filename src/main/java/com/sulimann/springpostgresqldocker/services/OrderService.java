package com.sulimann.springpostgresqldocker.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.sulimann.springpostgresqldocker.models.Order;
import com.sulimann.springpostgresqldocker.repositories.OrderRepository;
import com.sulimann.springpostgresqldocker.services.exceptions.DatabaseException;
import com.sulimann.springpostgresqldocker.services.exceptions.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    
    @Autowired
    private OrderRepository repository;

    public List<Order> findAll(){
       return repository.findAll();
    }

    public Order findById(Long id){
        Optional<Order> obj = repository.findById(id);        
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Order insert(Order obj){
        return repository.save(obj);
    }

    public void delete(Long id){
        try{
            repository.deleteById(id);
        }catch(EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        }catch(DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }

    }

    public Order update(Long id, Order obj){
        try{
            Order entity = repository.getOne(id);
            updateData(entity, obj);
            return repository.save(entity);
        }
        catch(EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }

    public void updateData(Order entity, Order obj){
        entity.setMoment(obj.getMoment());
        entity.setOrderStatus(obj.getOrderStatus());
        entity.setClient(obj.getClient());
    }
}
