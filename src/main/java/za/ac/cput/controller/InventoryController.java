/*

Controller for Inventory
Author: Shuaib Allie (217148867)
 */
package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.entity.AdminLogin;
import za.ac.cput.entity.Inventory;
import za.ac.cput.service.IInventoryService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("restaurant/inventory")
@Slf4j
public class InventoryController {

    private final IInventoryService inventoryService;

    @Autowired
    public InventoryController(IInventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @PostMapping("save")
    public ResponseEntity<Inventory> save(@Valid @RequestBody Inventory inventory){
        log.info("Save Request: {}", inventory);
        Inventory insert = inventoryService.save(inventory);
        return ResponseEntity.ok(insert);
    }

    @GetMapping("find/{id}")
    public ResponseEntity<Inventory> findById(@PathVariable String id) {
        log.info("Find by id request: {}", id);
        Inventory inventory = this.inventoryService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(inventory);
    }
    @DeleteMapping("delete-inventory")
    public ResponseEntity<Void>delete(Inventory inventory) {
        log.info("Delete request{}", inventory);
        this.inventoryService.delete(inventory);
        return ResponseEntity.noContent().build();

    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id){
        log.info("Delete request: {}", id);
        this.inventoryService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
    @GetMapping("all")
    public ResponseEntity<List<Inventory>>findAll(){
        List<Inventory> restaurantList=this.inventoryService.findAll();
        return ResponseEntity.ok(restaurantList);

    } }
