/*
ItemServiceImplTest
Author Craig Jarvis (220103216)
Date: 28 September 2022
 */

package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Item;
import za.ac.cput.factory.ItemFactory;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ItemServiceImplTest {

    @Autowired
    private ItemServiceImpl service;
    private final Item item = ItemFactory.createItem("1", "13", "15", "10.99");
    private final Item item2 = ItemFactory.createItem("1", "14", "15", "10.99");

    @Test
    @Order(1)
    void save() {
        Item create = this.service.save(item);
        Item create2 = this.service.save(item);
        assertNotNull(create);
        assertNotNull(create2);
        System.out.println(create);
    }

    @Test
    @Order(2)
    void findById() {
        Optional<Item> read = this.service.findById(item.getID());
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertNotEquals(this.item, read.get())
        );
        System.out.println(read);
    }

    @Test
    @Order(3)
    void findAll() {
        List<Item> list = this.service.findAll();
        System.out.println(list);
    }

    @Test
    @Order(4)
    void delete() {
        service.delete(item);
        List<Item> list = this.service.findAll();
        System.out.println(list);
    }

    @Test
    @Order(5)
    void deleteById() {
        service.deleteById("2");
        List<Item> list = this.service.findAll();
        System.out.println(list);
    }
}
