package com.poec.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poec.crm.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{
    
}
