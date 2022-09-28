/*
OrderControllerTest
Author Craig Jarvis (220103216)
Date: 28 September 2022
 */

package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.entity.Order;
import za.ac.cput.factory.OrderFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderControllerTest {
    @LocalServerPort
    private int port;
    @Autowired
    private ItemOrderController itemOrderController;
    @Autowired
    private TestRestTemplate restTemplate;

    private Order order;
    private String baseUrl;


    @BeforeEach
    void setUp(){
        order = OrderFactory.createOrder(13, "12 July", true);
        baseUrl = "http://localhost:" + port + "/restaurant/order/";
    }
    @Test
    @org.junit.jupiter.api.Order(1)
    void save() {
        String url = baseUrl + "save";
        ResponseEntity<Order> response = restTemplate.postForEntity(url, this.order, Order.class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    @org.junit.jupiter.api.Order(2)
    void findById() {
        String url = baseUrl + "find/" + this.order.getCustomerID();
        ResponseEntity<Order> response = this.restTemplate.getForEntity(url, Order.class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
        System.out.println(url);
        System.out.println(response);
    }

    @Test
    @org.junit.jupiter.api.Order(3)
    void findAll() {
        String url = baseUrl + "all";
        ResponseEntity<Order[]> response = restTemplate.getForEntity(url, Order[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertTrue(response.getBody().length == 1)
        );
    }

    @Test
    @org.junit.jupiter.api.Order(4)
    void delete() {
        String url = baseUrl + "delete-order";
        restTemplate.delete(url);
        System.out.println(url);
    }

    @Test
    @org.junit.jupiter.api.Order(5)
    void deleteById() {
        String url = baseUrl + "delete/" + order.getCustomerID();
        restTemplate.delete(url);
        System.out.println(url);
    }
}
