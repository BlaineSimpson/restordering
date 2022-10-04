/* ItemOrderController.java
 Entity for the ItemOrder
 Author: Blaine Simpson (218020171)


 */
package za.ac.cput.controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.AdminLogin;
import za.ac.cput.domain.ItemOrder;
import za.ac.cput.domain.Restaurant;
import za.ac.cput.service.IItemOrderService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("restaurant/itemOrder")
@Slf4j
public class ItemOrderController {

private  final IItemOrderService itemOrderService;

    @Autowired
    public ItemOrderController(IItemOrderService itemOrderService) {
        this.itemOrderService = itemOrderService;
    }

    @PostMapping("save")
    public ResponseEntity<ItemOrder> save(@Valid @RequestBody ItemOrder itemOrder){
        log.info("Save Request: {}", itemOrder);
        ItemOrder insert = itemOrderService.save(itemOrder);
        return ResponseEntity.ok(insert);
    }

    @GetMapping("find/{id}")
    public ResponseEntity<Optional<ItemOrder>> findById(@PathVariable String id){
        log.info("Read Request: {}", id);
        Optional<ItemOrder> find = itemOrderService.findById(id);
        return ResponseEntity.ok(find);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<ItemOrder> deleteById(@PathVariable String id){
        log.info("Delete request: {}", id);
        this.itemOrderService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("delete-itemOrder")
    public ResponseEntity<ItemOrder> delete(ItemOrder itemOrder){
        log.info("Delete Request: {}", itemOrder);
        this.itemOrderService.delete(itemOrder);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<ItemOrder>> findAll(){
        List<ItemOrder> itemOrderList = itemOrderService.findAll();
        return ResponseEntity.ok(itemOrderList);
    }
}

