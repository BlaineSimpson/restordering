/*
RestaurantController.java
Controller for restaurant
Author: Demi Farquhar (220322104)
Date: 4 August 2022
 */
package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.Restaurant;
import za.ac.cput.service.IRestaurantService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("restaurant/restaurant")
@Slf4j
public class RestaurantController {

    private final IRestaurantService restaurantService;

    @Autowired
    public RestaurantController(IRestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping("save")
    public ResponseEntity<Restaurant> save(@Valid @RequestBody Restaurant restaurant) {
        log.info("Save request: {}", restaurant);
        Restaurant save = restaurantService.save(restaurant);
        return ResponseEntity.ok(save);

    }

    @GetMapping("find/{id}")
    public ResponseEntity<Restaurant> findById(@PathVariable String id) {
        log.info("Find by id request: {}", id);
        Restaurant restaurant = this.restaurantService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(restaurant);
    }
    @DeleteMapping("delete-restaurant")
    public ResponseEntity<Void>delete(Restaurant restaurant) {
        log.info("Delete request{}", restaurant);
        this.restaurantService.delete(restaurant);
        return ResponseEntity.noContent().build();

    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id){
        log.info("Delete request: {}", id);
        this.restaurantService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
    @GetMapping("all")
    public ResponseEntity<List<Restaurant>>findAll(){
        List<Restaurant> restaurantList=this.restaurantService.findAll();
        return ResponseEntity.ok(restaurantList);

    }
}