package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.ItemOrder;

import static org.junit.jupiter.api.Assertions.*;

class ItemOrderFactoryTest {
    /* ItemOrderFactoryTest.java
     Entity for the ItemOrder
     Author: Blaine Simpson (218020171)
     Date: 01 April 2022

     */
    @Test
    void createItem() {
        ItemOrder item = ItemOrderFactory.createItemOrder("1","Pizza", "8");
        System.out.println(item);
        assertNotNull(item);
    }
}