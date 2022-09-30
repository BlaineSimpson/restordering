/* Customer.java
  Entity for the Customer
   Author: Sinovuyo Mlanjeni (219220387)
    Date: 05 August 2022
 */
package za.ac.cput.controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.entity.Customer;
import za.ac.cput.service.ICustomerService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping
@Slf4j
public class CustomerController {
    private final ICustomerService customerService;

    @Autowired
    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }


    /*@PostMapping("save")
    public ResponseEntity<Customer> save(@Valid @RequestBody Customer customer) {
        log.info("Save request: {}", customer);
        Customer save = customerService.save(customer);
        return ResponseEntity.ok(save);
    }*/
    @PostMapping("save")
    public ResponseEntity<Customer> save(@Valid @RequestBody Customer customer) {
        log.info("Save request: {}", customer);
        Customer save = customerService.save(customer);
        return ResponseEntity.ok(save);
    }


    @GetMapping("find/{id}")
    public ResponseEntity<Customer> findById(@PathVariable String id) {
        log.info("Find by id request: {}", id);
        Customer customer= this.customerService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(customer);
    }

    @DeleteMapping("delete-customer")
    public ResponseEntity<Void>delete(Customer customer) {
        log.info("Delete request{}", customer);
        this.customerService.delete(customer);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id){
        log.info("Delete request: {}", id);
        this.customerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<Customer>>findAll(){
        List<Customer> restaurantList=this.customerService.findAll();
        return ResponseEntity.ok(restaurantList);

    }

}
