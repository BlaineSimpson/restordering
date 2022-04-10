package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Item;

import static org.junit.jupiter.api.Assertions.*;

class ItemFactoryTest {
    /* ItemFactoryTest.java
     Entity for the Item
     Author: Blaine Simpson (218020171)
     Date: 01 April 2022

     */
    @Test
    void createItem() {
        Item item = ItemFactory.createItem("1","Pizza", "200");
        System.out.println(item);
        assertNotNull(item);
    }
}