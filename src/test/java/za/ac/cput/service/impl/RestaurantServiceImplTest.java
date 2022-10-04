/*
RestaurantServiceImplTest.java
Service Test for restaurant
Author: Demi Farquhar (220322104)
Date: 4 August 2022
 */

package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Restaurant;
import za.ac.cput.factory.RestaurantFactory;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class RestaurantServiceImplTest {

    @Autowired
    private RestaurantServiceImpl service;
    private final Restaurant restaurant1= RestaurantFactory.createRestaurant("01A","Joe's Cave","31 Park Sea Point",true);
    private final Restaurant restaurant2 =RestaurantFactory.createRestaurant("012B","Cafe", "18 Carter SomerSet West", true);

    @Test
    @Order(1)
    void save() {
        Restaurant create1=this.service.save(restaurant1);
        Restaurant create2= this.service.save(restaurant2);
        assertNotNull(create1);
        assertNotNull(create2);


        System.out.println(create1);
        System.out.println(create2);
        System.out.println();
    }

    @Test
    @Order(2)
    void findById() {
        Optional<Restaurant> read =this.service.findById(restaurant2.getRestaurantId());
        System.out.println(read);
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertNotEquals(this.restaurant1, read.get())
        );

        System.out.println();
    }

    @Test
    @Order(4)
    void delete() {
        service.delete(restaurant1);
        List<Restaurant> listRestaurant=this.service.findAll();
        System.out.println(listRestaurant);
        assertEquals(1,listRestaurant.size());
        System.out.println();
    }

    @Test
    @Order(3)
    void findAll() {
        List<Restaurant> listRestaurant= this.service.findAll();
        System.out.println(listRestaurant);
        assertEquals(2,listRestaurant.size());
        System.out.println();

    }

    @Test
    @Order(5)
    void deleteById() {
        service.deleteById("012B");
        List<Restaurant> listRestaurant=this.service.findAll();

        System.out.println(listRestaurant);
    }
}