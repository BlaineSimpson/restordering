/*
ItemControllerTest
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
import za.ac.cput.entity.Item;
import za.ac.cput.factory.ItemFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ItemControllerTest {
    @LocalServerPort
    private int port;
    @Autowired
    private ItemOrderController itemOrderController;
    @Autowired
    private TestRestTemplate restTemplate;

    private Item item;
    private String baseUrl;


    @BeforeEach
    void setUp(){
        item = ItemFactory.createItem(1, 13, 15, 10.99);
        baseUrl = "http://localhost:" + port + "/restaurant/item/";
    }
    @Test
    @Order(1)
    void save() {
        String url = baseUrl + "save";
        ResponseEntity<Item> response = restTemplate.postForEntity(url, this.item, Item.class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    @Order(2)
    void findById() {
        String url = baseUrl + "find/" + this.item.getID();
        ResponseEntity<Item> response = this.restTemplate.getForEntity(url, Item.class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
        System.out.println(url);
        System.out.println(response);
    }

    @Test
    @Order(3)
    void findAll() {
        String url = baseUrl + "all";
        ResponseEntity<Item[]> response = restTemplate.getForEntity(url, Item[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertTrue(response.getBody().length == 1)
        );
    }

    @Test
    @Order(4)
    void delete() {
        String url = baseUrl + "delete-item";
        restTemplate.delete(url);
        System.out.println(url);
    }

    @Test
    @Order(5)
    void deleteById() {
        String url = baseUrl + "delete/" + item.getID();
        restTemplate.delete(url);
        System.out.println(url);
    }
}
