/*
RestaurantServiceImpl.java
Service for restaurant
Author: Demi Farquhar (220322104)
Date: 4 August 2022
 */

package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Item;
import za.ac.cput.entity.Restaurant;
import za.ac.cput.repository.IRestaurantRepository;
import za.ac.cput.service.IRestaurantService;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceImpl implements IRestaurantService {

    private final IRestaurantRepository repository;


    @Autowired
    public RestaurantServiceImpl(IRestaurantRepository repository) {
        this.repository = repository;

    }

    @Override
    public Restaurant save(Restaurant restaurant) {
        return this.repository.save(restaurant);
    }

    @Override
    public Optional<Restaurant> findById(String id) {
        return this.repository.findById(id);
    }

    @Override
    public void delete(Restaurant restaurant) {
        this.repository.delete(restaurant);

    }

    @Override
    public List<Restaurant> findAll() {
        return this.repository.findAll();
    }

    @Override
    public void deleteById(String id) {
        Optional<Restaurant> restaurant = findById(id);
        if (restaurant.isPresent()) {
            delete(restaurant.get());

        }
    }
}
