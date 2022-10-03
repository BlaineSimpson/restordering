package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.entity.AdminLogin;
import za.ac.cput.entity.Orderr;
import za.ac.cput.factory.OrderFactory;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl service;
    private final Orderr order = OrderFactory.createOrder("0135A", "10 June 2020", false);
    private final Orderr order2 = OrderFactory.createOrder("1520J", "12 August 2020", true);

    @Test
    @Order(1)
    void save() {
        Orderr create = this.service.save(order);
        Orderr create2 = this.service.save(order2);
        assertNotNull(create);
        assertNotNull(create2);
        System.out.println(create);
    }

    @Test
    @Order(2)
    void findById() {
        Optional<Orderr> read = this.service.findById(this.order.getOrderID());
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertEquals(this.order, read.get())
        );
        System.out.println(read);
    }

    @Test
    @Order(3)
    void findAll() {
        List<Orderr> list = this.service.findAll();
        System.out.println(list);
    }

    @Test
    @Order(4)
    void delete() {
        service.delete(order); //delete admin 1
        List<Orderr> list = this.service.findAll();
        System.out.println(list);
    }

    @Test
    @Order(5)
    void deleteById() {
        service.deleteById("1520J"); //Deleted admin 2 (List should be empty)
        List<Orderr> list = this.service.findAll();
        System.out.println(list);
    }

}