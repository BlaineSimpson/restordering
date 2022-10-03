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
import za.ac.cput.entity.ItemOrder;
import za.ac.cput.service.IItemOrderService;

import javax.validation.Valid;
import java.util.List;

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
    public ResponseEntity<ItemOrder> save (@Valid @RequestBody ItemOrder itemOrder) {
        log.info("save request: {}", itemOrder);
        ItemOrder save = itemOrderService.save(itemOrder);
        return ResponseEntity.ok(save);
    }
    @GetMapping("find/{id}")
    public ResponseEntity<ItemOrder> findId (@PathVariable String id) {
        log.info("Find by id request: {}", id);
        ItemOrder itemOrder = this.itemOrderService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(itemOrder);
    }
        @DeleteMapping("delete-itemOrder")
        public ResponseEntity<ItemOrder> delete(@PathVariable String itemOrder){
            log.info("Delete request: {}",itemOrder);
            this.itemOrderService.deleteById(itemOrder);
            return ResponseEntity.noContent().build();
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<ItemOrder> deleteById(@PathVariable String id){
        log.info("Delete request: {}",id);
        this.itemOrderService.deleteById(id);
        return ResponseEntity.noContent().build();


    }
    @GetMapping("all")
    public  ResponseEntity<List<ItemOrder>>findAll(){
        List<ItemOrder> itemOrderList =this.itemOrderService.findAll();
        return ResponseEntity.ok(itemOrderList);
    }

}
