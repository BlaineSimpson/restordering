/*
TableFactory.java
Author Demi Alexis Farquhar (220322104)
Date: 7 April 2022
 */
package za.ac.cput.factory;

import za.ac.cput.entity.Table;

public class TableFactory {
public static Table createTable (String tableId, int tableNo, int noOfSeats, boolean isTableAvailable){
 Table table = new Table.Builder() .setTableId(tableId)
         .setTableNo(tableNo)
         .setNoOfSeats(noOfSeats)
         .setTableAvailable(isTableAvailable)
         .build();
 return table;
}
}
