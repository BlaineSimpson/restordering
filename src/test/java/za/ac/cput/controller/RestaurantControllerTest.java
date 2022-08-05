/*
RestaurantControllerTest.java
Controller Test for restaurant
Author: Demi Farquhar (220322104)
Date: 4 August 2022
 */
package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.entity.Restaurant;
import za.ac.cput.factory.RestaurantFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class RestaurantControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private RestaurantController restaurantController;

    @Autowired
    private TestRestTemplate restTemplate;

    private Restaurant restaurant;
    private String baseUrl;

    @BeforeEach
    void setup(){
        restaurant= RestaurantFactory.createRestaurant("012B","Cafe","36 Carter Sea Point", true);
        this.baseUrl="http://localhost:"+this.port+"/restaurant/restaurant/";
        assertNotNull(restaurantController);
    }

    @Test
    @Order(1)
    void save() {
        String url = baseUrl + "save";
        System.out.println(url);
        ResponseEntity<Restaurant> response = this.restTemplate
                .postForEntity(url, this.restaurant, Restaurant.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody()));

    }

    @Test
    @Order(2)
    void findById() {
        String url = baseUrl + "find/" + this.restaurant.getRestaurantId();
        ResponseEntity<Restaurant> response = this.restTemplate.getForEntity(url, Restaurant.class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
        System.out.println(url);
        System.out.println(response);

    }

    @Test
    @Order(4)
    void delete() {
        String url = baseUrl + "delete-restaurant";
        restTemplate.delete(url);
        System.out.println(url);
    }

    @Test
    @Order(5)
    void deleteById() {
        String url = baseUrl + "delete/" + restaurant.getRestaurantId();
        restTemplate.delete(url);
        System.out.println(url);
    }

    @Test
    @Order(3)
    void findAll() {
        String url = baseUrl + "all";
        System.out.println(url);
        ResponseEntity<Restaurant[]> response = this.restTemplate.getForEntity(url, Restaurant[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertEquals(1, response.getBody().length)
        );
    }
}