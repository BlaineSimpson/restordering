/*
OrderRepositoryTest.java
OrderRepositoryTest
Author Craig Jarvis (220103216)
Date: 9 April 2022
 */

package za.ac.cput.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Order;
import za.ac.cput.factory.OrderFactory;

@TestMethodOrder(MethodOrderer.MethodName.class)
class OrderRepositoryTest {
    private static OrderRepository repository
            = OrderRepository.getRepository();
    private static Order order =
            OrderFactory.createOrder(1, "4 April 2022", true);
    private static Order order2 =
            OrderFactory.createOrder(2, "6 April 2022", false);

    @Test
    void a_create() {
        Order created = repository.create(order);
        assertEquals(order.getCustomerID(), order.getCustomerID());
        System.out.println("Order: " + order);
    }

    @Test
    void a_create2(){
        Order created = repository.create(order2);
        assertEquals(order.getCustomerID(), order.getCustomerID());
        System.out.println("Order: " + order);
    }

    @Test
    void b_read() {
        Order read = repository.read(order.getCustomerID());
        assertNotNull(read);
        System.out.println("Read:" + read);
    }

    @Test
    void c_update() {
        Order updated = new
                Order.Builder().copy(order)
                .setCustomerID(20)
                .setOrderDate("5 April")
                .setReady(false)
                .build();
        System.out.println("Updated: " + updated);
    }

    @Test
    void d_delete() {
        boolean success = repository.delete(order.getOrderDate());
        System.out.println("Deleted: " + success);
    }

    @Test
    void e_getAll() {
        System.out.println("Show all: ");
        System.out.println(repository.getAll());
    }
}