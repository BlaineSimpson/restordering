package za.ac.cput.factory;

import za.ac.cput.entity.ItemOrder;

/* ItemOrderFactory.java
 Entity for the ItemOrder
 Author: Blaine Simpson (218020171)
 Date: 01 April 2022

 */
public class ItemOrderFactory {

    public static ItemOrder createItem(String ItemId, String ItemName, String NumberofPlates){
      return new ItemOrder.Builder().setItemId(ItemId)
              .setItemName(ItemName)
              .setNumberofPlates(NumberofPlates)
              .build();



    }
}
