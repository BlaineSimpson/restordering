package za.ac.cput.controller;

/* IItemOrderControllerTest.java
 Entity for the ItemOrder
 Author: Blaine Simpson (218020171)


 */
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.AdminLogin;
import za.ac.cput.domain.ItemOrder;

import za.ac.cput.factory.AdminLoginFactory;
import za.ac.cput.factory.ItemOrderFactory;


import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ItemOrderControllerTest {
    @LocalServerPort
    private int port;
    @Autowired
    private ItemOrderController itemOrderController;
    @Autowired
    private TestRestTemplate restTemplate;

    private ItemOrder itemOrder;
    private String baseUrl;


    @BeforeEach
    void setUp() {
        itemOrder = ItemOrderFactory.createItemOrder("1", "Pizza");
        baseUrl = "http://localhost:" + port + "/restaurant/admin/";
    }

    @Test
    @Order(1)
    void save() {
        String url = baseUrl + "save";
        ResponseEntity<ItemOrder> response = restTemplate.postForEntity(url, this.itemOrder, ItemOrder.class);
        assertAll(

                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    @Order(2)
    void findById() {
        String url = baseUrl + "find/" + this.itemOrder.getItemId();
        ResponseEntity<ItemOrder> response = this.restTemplate.getForEntity(url, ItemOrder.class);
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
        ResponseEntity<ItemOrder[]> response = restTemplate.getForEntity(url, ItemOrder[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),

                () -> assertTrue(response.getBody().length == 1)
        );
    }

    @Test
    @Order(4)
    void delete() {
        String url = baseUrl + "delete-itemOrder";
        restTemplate.delete(url);
        System.out.println(url);
    }

    @Test
    @Order(5)
    void deleteById() {
        String url = baseUrl + "delete/" + itemOrder.getItemId();
        restTemplate.delete(url);
        System.out.println(url);
    }
}