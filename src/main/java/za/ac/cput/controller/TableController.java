/*
TableController.java
Controller for restaurant
Author: Demi Farquhar (220322104)
Date: 5 August 2022
 */
package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.entity.Tablee;
import za.ac.cput.service.ITableService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("restaurant/tablee")
@Slf4j
public class TableController {

    private final ITableService service;

    @Autowired
    public TableController(ITableService service ){
        this.service=service;
    }

    @PostMapping("save")
    public ResponseEntity<Tablee>save(@Valid @RequestBody Tablee tablee){
        log.info("Save request:{} ", tablee);
        Tablee save= service.save(tablee);
        return ResponseEntity.ok(save);
    }
    @GetMapping("find/{id}")
    public ResponseEntity<Tablee>findById(@PathVariable String id){
        log.info("Find by id request: {}", id);
        Tablee tablee=this.service.findById(id)
                .orElseThrow(()-> new ResponseStatusException((HttpStatus.NOT_FOUND) ));
        return ResponseEntity.ok(tablee);
    }
    @DeleteMapping("delete-tablee")
    public ResponseEntity<Void>delete(Tablee tablee){
        log.info("Delete request{}", tablee);
        this.service.delete(tablee);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id){
        log.info("Delete request: {} ",id);
        this.service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("all")
    public ResponseEntity<List< Tablee>>findAll(){
        List<Tablee>tableeList=this.service.findAll();
        return ResponseEntity.ok(tableeList);

    }
}
