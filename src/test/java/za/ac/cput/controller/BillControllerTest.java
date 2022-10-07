/* Bill.java
  Entity for the Bill
   Author: Sinovuyo Mlanjeni (219220387)
    Date: 05 August 2022
 */
package za.ac.cput.controller;


import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Bill;
import za.ac.cput.factory.BillFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BillControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private BillController controller;

    @Autowired
    private TestRestTemplate restTemplate;

    private Bill bill;
    private String baseUrl;
    @BeforeEach
    void setUp(){
        bill = BillFactory.createBill("6682", "22 June 2021","5887", " R458", " Paid with cash", 658);
        baseUrl = "http://localhost:" + port + "/restaurant/bill/";
    }
    @Test
    @Order(1)
    void save() {
        String url = baseUrl + "save";
        ResponseEntity<Bill> response = restTemplate.postForEntity(url, this.bill,Bill.class);
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
        String url = baseUrl + "find/" + this.bill.getBillId();
        ResponseEntity<Bill> response = this.restTemplate.getForEntity(url, Bill.class);
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
        ResponseEntity<Bill[]> response = restTemplate.getForEntity(url, Bill[].class);
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
        String url = baseUrl + "delete-bill";
        restTemplate.delete(url);
        System.out.println(url);
    }
    @Test
    @Order(5)
    void deleteById() {
        String url = baseUrl + "delete/" + bill.getBillId();
        restTemplate.delete(url);
        System.out.println(url);
    }

}