/*

Author: Shuaib Allie (217148867)

 */
package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Restaurant;
import za.ac.cput.domain.Supplier;
import za.ac.cput.factory.SupplierFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SupplierControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private SupplierController supplierController;

    @Autowired
    private TestRestTemplate restTemplate;

    private Supplier supplier;
    private String baseUrl;

    @BeforeEach
    void setup(){
        supplier= SupplierFactory.createSupplier("Johns","28 Art Road","johns21@gmail.com", "021456257", "23A");
        this.baseUrl="http://localhost:"+this.port+"/restaurant/supplier/";
        assertNotNull(supplierController);
    }

    @Test
    @Order(1)
    void save() {
        String url = baseUrl + "save";
        System.out.println(url);
        ResponseEntity<Supplier> response = this.restTemplate
                .postForEntity(url, this.supplier, Supplier.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody()));


    }

    @Test
    @Order(2)
    void findById() {
        String url = baseUrl + "find/" + this.supplier.getSuppName();
        ResponseEntity<Supplier> response = this.restTemplate.getForEntity(url, Supplier.class);
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
        String url = baseUrl + "delete/" + supplier.getSuppName();
        restTemplate.delete(url);
        System.out.println(url);
    }

    @Test
    @Order(3)
    void findAll() {
        String url = baseUrl + "all";
        System.out.println(url);
        ResponseEntity<Supplier[]> response = this.restTemplate.getForEntity(url, Supplier[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertEquals(2, response.getBody().length)
        );
    }
}

