package za.ac.cput.factory;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Item;
import za.ac.cput.entity.Order;

class OrderFactoryTest {
    @Test
    public void notNullValues(){
        Order order = OrderFactory.createOrder(1, "5 Apr", true);

        assertNotNull(order);

        System.out.println(order);

        System.out.println(order.getCustomerID());
        System.out.println(order.getOrderDate());
        System.out.println(order.isReady());
    }
}