/*
RestaurantFactory.java
Author Demi Alexis Farquhar (220322104)
Date: 7 April 2022
 */
package za.ac.cput.factory;

import za.ac.cput.entity.Restaurant;

public class RestaurantFactory {
    public static Restaurant createRestaurant(String restaurantId, String restaurantName,String restaurantaAdress, boolean isOpen){
    Restaurant restaurant= new Restaurant.Builder().setRestaurantId(restaurantId)
            .setRestaurantName(restaurantName)
            .setRestaurantAddress(restaurantaAdress)
            .setOpen(isOpen)
            .build();
    return restaurant;
    }


}
