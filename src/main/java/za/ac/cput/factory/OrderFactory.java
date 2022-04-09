/*
OrderFactory.java
OrderFactory entity
Author Craig Jarvis (220103216)
Date: 9 April 2022
 */

package za.ac.cput.factory;

import za.ac.cput.entity.Order;

public class OrderFactory {

    public static Order createItem(Integer custNum, String date, boolean ready){
        Order order = new Order.Builder().setCustomerID(custNum)
                .setOrderDate(date)
                .setReady(ready)
                .build();
        return order;
    }

}
