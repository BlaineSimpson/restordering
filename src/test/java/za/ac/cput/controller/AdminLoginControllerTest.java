/* AdminLoginControllerTest.java
 Testing the admin controller
 Author: Ali Mohamed (219113505)
 Date: 27 July 2022
*/
package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.entity.AdminLogin;
import za.ac.cput.factory.AdminLoginFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AdminLoginControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private AdminLoginController controller;
    //Used to test our web services
    @Autowired private TestRestTemplate restTemplate;

    private AdminLogin admin;
    private String baseUrl;

    @BeforeEach
    void setUp(){
        admin = AdminLoginFactory.createAdmin("1", "username", "password");
        baseUrl = "http://localhost:" + port + "/restaurant/admin/";
    }
    @Test
    @Order(1)
    void save() {
        String url = baseUrl + "save";
        ResponseEntity<AdminLogin> response = restTemplate.postForEntity(url, this.admin, AdminLogin.class);
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
        String url = baseUrl + "find/" + this.admin.getAdminLoginId();
        ResponseEntity<AdminLogin> response = this.restTemplate.getForEntity(url, AdminLogin.class);
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
        ResponseEntity<AdminLogin[]> response = restTemplate.getForEntity(url, AdminLogin[].class);
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
        String url = baseUrl + "delete-admin";
        restTemplate.delete(url);
        System.out.println(url);
    }
}