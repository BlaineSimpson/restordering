/*
RestaurantRepositoryTest.java
Author Demi Alexis Farquhar (220322104)
Date: 7 April 2022
 */

package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Restaurant;
import za.ac.cput.factory.RestaurantFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
class RestaurantRepositoryTest {
    private static RestaurantRepository repository= RestaurantRepository.getRepository();
    private static Restaurant restaurant= RestaurantFactory.createRestaurant("01A","Spur","10 Dave Road Darling",true);

    @Test
    void a_create() {
        Restaurant created= repository.create(restaurant);
        assertEquals(restaurant.getRestaurantId(),created.getRestaurantId());
        System.out.println("Create restaurant: ");
        System.out.println(created);
        System.out.println();
    }

    @Test
    void b_read() {
        Restaurant read=repository.read(restaurant.getRestaurantId());
        assertNotNull(read);
        System.out.println("Read restaurant: ");
        System.out.println(read);
        System.out.println();
    }

    @Test
    void c_update() {
        Restaurant updated= new Restaurant.Builder().copy(restaurant).setOpen(false).build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated version Of restaurant: ");
        System.out.println(updated);
        System.out.println();
    }

    @Test
    void e_delete() {
        boolean success=repository.delete(restaurant.getRestaurantId());
        assertTrue(success);
        System.out.println("Delete restaurant: ");
        System.out.println(success);
        System.out.println();
    }

    @Test
    void d_getAll() {
        System.out.println("Show all Restaurants: ");
        System.out.println(repository.getAll());
        System.out.println();
    }
}