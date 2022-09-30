/* Customer.java
  Entity for the Customer
   Author: Sinovuyo Mlanjeni (219220387)
    Date: 05 August 2022
 */
package za.ac.cput.controller;


import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import za.ac.cput.entity.Customer;
import za.ac.cput.factory.CustomerFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CustomerControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private AdminLoginController controller;
    //Used to test our web services
    @Autowired
    private TestRestTemplate restTemplate;

    private Customer customer;
    private String baseUrl;

    @BeforeEach
    void setUp(){
        customer = CustomerFactory.createCustomer("57522", "Mike", "Williams", "586852@cput.ac.za", "1 Hofmayr Lane, Cape Town");
        baseUrl = "http://localhost:" + port + "/customer/customer/";
    }

    @Test
    @Order(1)
    void save() {
        String url = baseUrl + "save";
        ResponseEntity<Customer> response = restTemplate.postForEntity(url, this.customer, Customer.class);
        assertAll(
                //checking to see that the statusCode for response matches OK (that it is successful)
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                //checking that response has a body
                () -> assertNotNull(response.getBody())
        );
    }
    @Test
    @Order(2)
    void findById() {
        String url = baseUrl + "find/" + this.customer.getCusId();
        ResponseEntity<Customer> response = this.restTemplate.getForEntity(url, Customer.class);
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
        ResponseEntity<Customer[]> response = restTemplate.getForEntity(url, Customer[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                //length is the number of insertion done
                () -> assertTrue(response.getBody().length == 1)
        );
    }
    @Test
    @Order(4)
    void delete() {
        String url = baseUrl + "delete-customer";
        restTemplate.delete(url);
        System.out.println(url);
    }

    @Test
    @Order(5)
    void deleteById() {
        String url = baseUrl + "delete/" + customer.getCusId();
        restTemplate.delete(url);
        System.out.println(url);
    }



}