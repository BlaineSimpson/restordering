/*
RestaurantFactoryTest.java
Author Demi Alexis Farquhar (220322104)
Date: 7 April 2022
 */

package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Restaurant;

import static org.junit.jupiter.api.Assertions.*;

class RestaurantFactoryTest {

    @Test
void createRestaurant() {
        Restaurant restaurant= RestaurantFactory.createRestaurant("01A","Spur","12 Woods Totaki", true);
        assertNotNull(restaurant);
        System.out.println("Create Restaurant ");
        System.out.println(restaurant);
        System.out.println("Restaurant added....");
    }


}