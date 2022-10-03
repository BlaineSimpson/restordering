/*
ItemFactoryTest.java
ItemFactoryTest
Author Craig Jarvis (220103216)
Date: 9 April 2022
 */

package za.ac.cput.factory;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Item;

class ItemFactoryTest {
    @Test
    public void notNullValues(){
        Item item = ItemFactory.createItem("1", "3", "56", "40.99");

        assertNotNull(item);

        System.out.println(item);

        System.out.println(item.getID());
        System.out.println(item.getOrderID());
        System.out.println(item.getQuantity());
    }

}