/* UserLoginControllerTest.java
 Testing the user controller
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
import za.ac.cput.domain.UserLogin;
import za.ac.cput.factory.UserLoginFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserLoginControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private UserLoginController controller;
    //Used to test our web services
    @Autowired private TestRestTemplate restTemplate;

    private UserLogin user;
    private String baseUrl;

    @BeforeEach
    void setUp(){
        user = UserLoginFactory.createUser("1", "username", "passowrd");
        baseUrl = "http://localhost:" + port + "/restaurant/user/";
    }

    @Test
    @Order(1)
    void save() {
        String url = baseUrl + "save";
        ResponseEntity<UserLogin> response = restTemplate.postForEntity(url, this.user, UserLogin.class);
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
        String url = baseUrl + "find/" + this.user.getUserLoginId();
        ResponseEntity<UserLogin> response = this.restTemplate.getForEntity(url, UserLogin.class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    @Order(3)
    void findAll() {
        String url = baseUrl + "all";
        ResponseEntity<UserLogin[]> response = restTemplate.getForEntity(url, UserLogin[].class);
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
        String url = baseUrl + "delete-user";
        restTemplate.delete(url);
        System.out.println(url);
    }

    @Test
    @Order(5)
    void deleteById() {
        String url = baseUrl + "delete/" + user.getUserLoginId();
        restTemplate.delete(url);
        System.out.println(url);
    }
}