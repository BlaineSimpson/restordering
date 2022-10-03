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
import za.ac.cput.entity.Orderr;
import za.ac.cput.service.IOrderService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("restaurant/order")
@Slf4j
public class OrderController {

    private final IOrderService orderService;
    @Autowired
    public OrderController(IOrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("save")
    public ResponseEntity<Orderr> save(@Valid @RequestBody Orderr order){
        log.info("Save Request: {}", order);
        Orderr insert = orderService.save(order);
        return ResponseEntity.ok(insert);
    }

    @GetMapping("find/{id}")
    public ResponseEntity<Optional<Orderr>> findById(@PathVariable String id){
        log.info("Read Request: {}", id);
        Optional<Orderr> find = orderService.findById(id);
        return ResponseEntity.ok(find);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Orderr> deleteById(@PathVariable String id){
        log.info("Delete request: {}", id);
        this.orderService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("delete-admin")
    public ResponseEntity<Orderr> delete(Orderr order){
        log.info("Delete Request: {}", order);
        this.orderService.delete(order);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<Orderr>> findAll(){
        List<Orderr> OrderList = orderService.findAll();
        return ResponseEntity.ok(OrderList);
    }
}