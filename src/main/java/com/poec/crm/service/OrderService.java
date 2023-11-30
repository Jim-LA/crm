package com.poec.crm.service;

import com.poec.crm.model.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poec.crm.repository.OrderRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    //SELECT *
    public List<Order> getOrder(){
        return orderRepository.findAll();
    }
    //CREATE
    public void addOrder(Order order){
        orderRepository.save(order);
    }
        //SELECT by Id
    public Optional<Order> findById(Integer id){
        Optional<Order> optional = orderRepository.findById(id);
        return optional;
    }
    //UPDATE by Id
    public Order updateOrder(Order order){
        return orderRepository.save(order);
    }
    //DELETE client
    public void deleteOrder(Integer id){
        orderRepository.deleteById(id);
    }
    
}
