/*
OrderServiceImplTest
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
import za.ac.cput.entity.Order;
import za.ac.cput.factory.OrderFactory;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderServiceImplTest {
    @Autowired
    private OrderServiceImpl service;
    private final Order order = OrderFactory.createOrder(13, "12 July", true);
    private final Order order2 = OrderFactory.createOrder(14, "10 August", false);

    @Test
    @Order(1)
    void save() {
        Order create = this.service.save(order);
        Order create2 = this.service.save(order);
        assertNotNull(create);
        assertNotNull(create2);
        System.out.println(create);
    }

    @Test
    @Order(2)
    void findById() {
        Optional<Order> read = this.service.findById(this.order.getClass());
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertEquals(this.order, read.get())
        );
        System.out.println(read);
    }

    @Test
    @Order(3)
    void findAll() {
        List<Order> list = this.service.findAll();
        System.out.println(list);
    }

    @Test
    @Order(4)
    void delete() {
        service.delete(order);
        List<Order> list = this.service.findAll();
        System.out.println(list);
    }

    @Test
    @Order(5)
    void deleteById() {
        service.deleteById("2");
        List<Order> list = this.service.findAll();
        System.out.println(list);
    }
}
