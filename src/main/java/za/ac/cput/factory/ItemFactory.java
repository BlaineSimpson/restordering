package za.ac.cput.factory;

import za.ac.cput.entity.Item;

/* ItemFactory.java
 Entity for the Item
 Author: Blaine Simpson (218020171)
 Date: 01 April 2022

 */
public class ItemFactory {

    public static Item createItem(String ItemId, String ItemName, String price){
      return new Item.Builder().setItemId(ItemId)
              .setItemName(ItemName)
              .setPrice(price)
              .build();



    }
}
