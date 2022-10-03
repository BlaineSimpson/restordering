/*
Item Controller
ItemController entity
Author Craig Jarvis (220103216)
Date: 25 September 2022
 */
package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.Item;
import za.ac.cput.service.IItemService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("restaurant/item")
@Slf4j
public class ItemController {

    private final IItemService itemService;
    @Autowired
    public ItemController(IItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping("save")
    public ResponseEntity<Item> save(@Valid @RequestBody Item item){
        log.info("Save Request: {}", item);
        Item insert = itemService.save(item);
        return ResponseEntity.ok(insert);
    }

    @GetMapping("find/{id}")
    public ResponseEntity<Optional<Item>> findById(@PathVariable String id){
        log.info("Read Request: {}", id);
        Optional<Item> find = itemService.findById(id);
        return ResponseEntity.ok(find);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Item> deleteById(@PathVariable String id){
        log.info("Delete request: {}", id);
        this.itemService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("delete-item")
    public ResponseEntity<Item> delete(Item item){
        log.info("Delete Request: {}", item);
        this.itemService.delete(item);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<Item>> findAll(){
        List<Item> itemList = itemService.findAll();
        return ResponseEntity.ok(itemList);
    }
}
