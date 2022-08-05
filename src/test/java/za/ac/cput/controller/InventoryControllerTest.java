/*

Author: Shuaib Allie (217148867)

 */
package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.entity.Inventory;
import za.ac.cput.factory.InventoryFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class InventoryControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private InventoryController inventoryController;

    @Autowired
    private TestRestTemplate restTemplate;

    private Inventory inventory;
    private String baseUrl;

    @BeforeEach
    void setup(){
        inventory= InventoryFactory.createInventory("012B","HotDog","Sausages", "Johnston", 23, 30);
        this.baseUrl="http://localhost:"+this.port+"/inventory/inventory/";
        assertNotNull(inventoryController);
    }

    @Test
    @Order(1)
    void save() {
        String url = baseUrl + "save";
        System.out.println(url);
        ResponseEntity<Inventory> response = this.restTemplate
                .postForEntity(url, this.inventory, Inventory.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody()));

    }

    @Test
    @Order(2)
    void findById() {
        String url = baseUrl + "find/" + this.inventory.getInv();
        ResponseEntity<Inventory> response = this.restTemplate.getForEntity(url, Inventory.class);
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
        String url = baseUrl + "delete-inventory";
        restTemplate.delete(url);
        System.out.println(url);
    }

    @Test
    @Order(5)
    void deleteById() {
        String url = baseUrl + "delete/" + inventory.getInv();
        restTemplate.delete(url);
        System.out.println(url);
    }

    @Test
    @Order(3)
    void findAll() {
        String url = baseUrl + "all";
        System.out.println(url);
        ResponseEntity<Inventory[]> response = this.restTemplate.getForEntity(url, Inventory[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertEquals(1, response.getBody().length)
        );
    }
}
