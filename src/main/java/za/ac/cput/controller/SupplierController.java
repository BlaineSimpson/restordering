/*

Controller for Supplier
Author: Shuaib Allie (217148867)
 */
package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.Supplier;
import za.ac.cput.service.ISupplierService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("restaurant/supplier")
@Slf4j
public class SupplierController {

    private final ISupplierService supplierService;

    @Autowired
    public SupplierController(ISupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @PostMapping("save")
    public ResponseEntity<Supplier> save(@Valid @RequestBody Supplier supplier) {
        log.info("Save request: {}", supplier);
        Supplier save = supplierService.save(supplier);
        return ResponseEntity.ok(save);

    }

    @GetMapping("find/{id}")
    public ResponseEntity<Supplier> findById(@PathVariable String id) {
        log.info("Find by id request: {}", id);
        Supplier supplier = this.supplierService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(supplier);
    }
    @DeleteMapping("delete-supplier")
    public ResponseEntity<Void>delete(Supplier supplier) {
        log.info("Delete request{}", supplier);
        this.supplierService.delete(supplier);
        return ResponseEntity.noContent().build();

    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id){
        log.info("Delete request: {}", id);
        this.supplierService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
    @GetMapping("all")
    public ResponseEntity<List<Supplier>>findAll(){
        List<Supplier> restaurantList=this.supplierService.findAll();
        return ResponseEntity.ok(restaurantList);

    } }
