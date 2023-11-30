package com.poec.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

import com.poec.crm.model.Order;
import com.poec.crm.service.OrderService;


@RestController
@RequestMapping("apiOrder")
public class OrderController {
    
    @Autowired
    OrderService orderService;

    //SELECT *
    @GetMapping("orders")
    public List<Order> getAll(){
        return orderService.getOrder();
    }
    //CREATE
    @PostMapping("orders")
    public void addOrder(@RequestBody Order order){
        orderService.addOrder(order);
    }
    //SELECT by Id
    @GetMapping("order/{id}")
    public ResponseEntity<Order> findById(@PathVariable Integer id) {
       Optional<Order> optional = orderService.findById(id);
       if (optional.isEmpty()) {
        return ResponseEntity.notFound().build();
       }else{
        return ResponseEntity.ok(optional.get());
       }
    }
    //UPDATE by Id
    @PutMapping("order")
    public ResponseEntity<?> update(@RequestBody Order order){
        Order orderUpdated = orderService.updateOrder(order);
        if (orderUpdated != null) {
            return ResponseEntity.status(204).body("Commande mise à jour avec succès !");
        }else{
            return ResponseEntity.status(403).build();
        }

    }
    //DELETE order
    @DeleteMapping("order/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> deleteOrder(@PathVariable Integer id){
        if (orderService.findById(id).isEmpty() == true) {
            return ResponseEntity.notFound().build();
        }else{
            orderService.deleteOrder(id);
            return ResponseEntity.ok().body("La commande a bien été supprimé ! ");
        }
    }
}
