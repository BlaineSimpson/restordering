/*
TableControllerTest.java
Controller test for table
Author: Demi Farquhar (220322104)
Date: 5 August 2022
 */
package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Tablee;
import za.ac.cput.factory.TableFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TableControllerTest {

    @LocalServerPort
    private int port;
    @Autowired
    private TableController tableController;
    
    @Autowired
    private TestRestTemplate restTemplate;

    private Tablee tablee;
    private String baseUrl;

    @BeforeEach
    void setup(){
        tablee= TableFactory.createTable("125A","2","8",false);
        this.baseUrl="http://localhost:"+this.port+"/restaurant/tablee/";
        assertNotNull(tableController);
    }

    @Test
    @Order(1)
    void save() {
        String url = baseUrl + "save";
        System.out.println(url);
        ResponseEntity<Tablee> response = this.restTemplate
                .postForEntity(url, this.tablee, Tablee.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody()));

    }

    @Test
    @Order(2)
    void findById() {
        String url = baseUrl + "find/" + this.tablee.getTableId();
        ResponseEntity<Tablee> response = this.restTemplate.getForEntity(url, Tablee.class);
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
        String url = baseUrl + "delete-tablee";
        restTemplate.delete(url);
        System.out.println(url);
    }

    @Test
    @Order(5)
    void deleteById() {
        String url = baseUrl + "delete/" + tablee.getTableId();
        restTemplate.delete(url);
        System.out.println(url);
    }

    @Test
    @Order(3)
    void findAll() {
        String url = baseUrl + "all";
        System.out.println(url);
        ResponseEntity<Tablee[]> response = this.restTemplate.getForEntity(url, Tablee[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertEquals(1, response.getBody().length)
        );
    }
}