/*
Order Controller
OrderController entity
Author Craig Jarvis (220103216)
Date: 25 September 2022
 */
package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.Order;
import za.ac.cput.service.IOrderService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("restaurant/admin")
@Slf4j
public class OrderController {

    private final IOrderService orderService;
    @Autowired
    public OrderController(IOrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("save")
    public ResponseEntity<Order> save(@Valid @RequestBody Order order){
        log.info("Save Request: {}", order);
        Order insert = orderService.save(order);
        return ResponseEntity.ok(insert);
    }

    @GetMapping("find/{id}")
    public ResponseEntity<Optional<Order>> findById(@PathVariable String id){
        log.info("Read Request: {}", id);
        Optional<Order> find = orderService.findById(id);
        return ResponseEntity.ok(find);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Order> deleteById(@PathVariable String id){
        log.info("Delete request: {}", id);
        this.orderService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("delete-admin")
    public ResponseEntity<Order> delete(Order order){
        log.info("Delete Request: {}", order);
        this.orderService.delete(order);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<Order>> findAll(){
        List<Order> OrderList = orderService.findAll();
        return ResponseEntity.ok(OrderList);
    }
}