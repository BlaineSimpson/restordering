/*
TableFactory.java
Author Demi Alexis Farquhar (220322104)
Date: 7 April 2022
 */
package za.ac.cput.factory;

import za.ac.cput.entity.Tablee;

public class TableFactory {
public static Tablee createTable (String tableId, String tableNo, String noOfSeats, boolean isTableAvailable){
 Tablee table = new Tablee.Builder() .setTableId(tableId)
         .setTableNo(tableNo)
         .setNoOfSeats(noOfSeats)
         .setTableAvailable(isTableAvailable)
         .build();
 return table;
}
}
