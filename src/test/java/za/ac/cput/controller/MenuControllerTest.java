package za.ac.cput.controller;
/* MenuControllerTest.java
 Entity for the Menu
 Author: Blaine Simpson (218020171)


 */
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.AdminLogin;
import za.ac.cput.domain.Menu;
import za.ac.cput.factory.MenuFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MenuControllerTest {
@LocalServerPort
private int port;
@Autowired
private MenuController menuController;
@Autowired
private TestRestTemplate restTemplate;

private Menu menu;
private String baseUrl;

@BeforeEach
void setup(){
    menu = MenuFactory.createMenu("A","Kiddies");
    this.baseUrl= "http://localhost:"+ this.port+"/restaurant/menu/";


}
@Test
@Order(1)
    void save() {
    String url = baseUrl + "save";
    System.out.println(url);
    ResponseEntity<Menu> response = this.restTemplate
            .postForEntity(url, this.menu, Menu.class);
    System.out.println(response);
    assertAll(
            () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
            ()-> assertNotNull(response.getBody()));
    }

    @Test
    @Order(2)
    void findId() {

            String url = baseUrl + "find/" + this.menu.getMenuId();
            ResponseEntity<Menu> response = this.restTemplate.getForEntity(url, Menu.class);
            assertAll(
                    () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                    () -> assertNotNull(response.getBody())
            );
            System.out.println(url);
            System.out.println(response);

    }

    @Test
    @Order(4)
    void delete(){
    String url = baseUrl + "delete-menu";
    restTemplate.delete(url);
        System.out.println(url);

    }

    @Test
    @Order(5)
    void deleteById() {
    String url = baseUrl + "delete/" + menu.getMenuT();
    restTemplate.delete(url);
        System.out.println(url);
    }

    @Test
    @Order(3)
    void findAll() {
    String url = baseUrl +"all";
        System.out.println(url);
        ResponseEntity<Menu[]> response = this.restTemplate.getForEntity(url, Menu[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertEquals(1, response.getBody().length)
        );
    }
}