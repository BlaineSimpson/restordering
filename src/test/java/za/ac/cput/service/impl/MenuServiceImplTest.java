package za.ac.cput.service.impl;
/* MenuServiceTest.java
 Entity for the Menu
 Author: Blaine Simpson (218020171)


 */
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.entity.Menu;
import za.ac.cput.factory.MenuFactory;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MenuServiceImplTest {
    private MenuServiceImpl service;
    private final Menu menu1 = MenuFactory.createMenu("menuA","Kiddies" );
    private final Menu menu2 = MenuFactory.createMenu("menuB","Drink List" );

    @Test
    @Order(1)
    void save() {
        Menu create1= this.service.save(menu1);
        Menu create2 = this.service.save(menu2);
        assertNotNull(create1);
        assertNotNull(create2);

        System.out.println(create1);
        System.out.println(create2);
    }

    @Test
    @Order(2)
    void findById() {
        Optional<Menu> read =this.service.findById(menu2.getMenuId());
        System.out.println(read);
        assertAll(
                () -> assertTrue(read.isPresent()),
                        () -> assertNotEquals(this.menu1, read.get())
        );
        System.out.println();
    }

    @Test
    @Order(4)
    void delete() {
        service.delete(menu1);
        List<Menu> listMenu =this.service.findAll();
        System.out.println(listMenu);
        assertEquals(1,listMenu.size() );
        System.out.println();
    }

    @Test
    @Order(3)
    void findAll() {
        List<Menu> listMenu = this.service.findAll();
        System.out.println(listMenu);
        assertEquals(2, listMenu.size());
        System.out.println();
    }

    @Test
    @Order(5)
    void deleteById() {
        service.deleteById("menuB");
        List<Menu>listMenu= this.service.findAll();
        System.out.println(listMenu);
    }
}