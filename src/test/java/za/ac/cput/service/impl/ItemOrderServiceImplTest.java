package za.ac.cput.service.impl;
/* ItemOrderServiceTest.java
 Entity for the ItemOrder
 Author: Blaine Simpson (218020171)


 */
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.entity.ItemOrder;
import za.ac.cput.factory.ItemOrderFactory;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ItemOrderServiceImplTest {
    @Autowired
    private ItemOrderServiceImpl service;
    private final ItemOrder itemOrder1 = ItemOrderFactory.createItemOrder("A", "Chips", "2");
    private final ItemOrder itemOrder2 = ItemOrderFactory.createItemOrder("B", "Pizza", "3");

    @Test
    @Order(1)
    void save() {
        ItemOrder create1 = this.service.save(itemOrder1);
        ItemOrder create2 = this.service.save(itemOrder2);
        assertNotNull(create1);
        assertNotNull(create2);

        System.out.println(create1);
        System.out.println(create2);
    }

    @Test
    @Order(2)
    void findById() {
        Optional<ItemOrder> read = this.service.findById(itemOrder2.getItemId());
        System.out.println(read);
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertNotEquals(this.itemOrder1, read.get())
        );
        System.out.println();
    }

    @Test
    @Order(4)
    void delete() {
        service.delete(itemOrder1);
        List<ItemOrder> listItemOrder = this.service.findAll();
        System.out.println(listItemOrder);
        assertEquals(1, listItemOrder.size());
        System.out.println();
    }

    @Test
    @Order(3)
    void findAll() {
        List<ItemOrder> listItemOrder = this.service.findAll();
        System.out.println(listItemOrder);
        assertEquals(2, listItemOrder.size());
        System.out.println();
    }

    @Test
    @Order(5)
    void deleteById() {
        service.deleteById("A");
        List<ItemOrder> listItemOrder = this.service.findAll();
        System.out.println(listItemOrder);
    }
}