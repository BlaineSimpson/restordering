package za.ac.cput.factory;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Orderr;

class OrderFactoryTest {
    @Test
    public void notNullValues(){
        Orderr order = OrderFactory.createOrder("1", "5 Apr", true);

        assertNotNull(order);

        System.out.println(order);

        System.out.println(order.getOrderID());
        System.out.println(order.getOrderDate());
        System.out.println(order.isReady());
    }
}