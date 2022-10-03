/* Bill.java
  Interface service for  Bill
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
import za.ac.cput.domain.Bill;
import za.ac.cput.service.IBillService;
import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping ("restaurant/bill")
@Slf4j

public class BillController {
    private final IBillService billService;

    @Autowired
    public BillController(IBillService billService) {
        this.billService = billService;
    }

    @PostMapping("save")
    public ResponseEntity<Bill> save(@Valid @RequestBody Bill bill) {
        log.info("Save request: {}", bill);
        Bill save = billService.save(bill);
        return ResponseEntity.ok(save);

    }

    @GetMapping("find/{id}")
    public ResponseEntity<Bill> findById(@PathVariable String id) {
        log.info("Find by id request: {}", id);
        Bill bill= this.billService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(bill);
    }

    @DeleteMapping("delete-bill")
    public ResponseEntity<Void>delete(Bill bill) {
        log.info("Delete request{}", bill);
        this.billService.delete(bill);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping ("delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id){
        log.info("Delete request: {}", id);
        this.billService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<Bill>>findAll(){
        List<Bill> restaurantList=this.billService.findAll();
        return ResponseEntity.ok(restaurantList);

    }

}
