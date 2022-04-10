/*
ItemFactory.java
ItemFactory entity
Author Craig Jarvis (220103216)
Date: 9 April 2022
 */

package za.ac.cput.factory;

import za.ac.cput.entity.Item;

public class ItemFactory {

    public static Item createItem(Integer identityNum, Integer orderID, Integer numStock, double price){
        Item item = new Item.Builder().setID(identityNum)
                .setOrderID(orderID)
                .setQuantity(numStock)
                .setPrice(price)
                .build();
        return item;
    }

}
