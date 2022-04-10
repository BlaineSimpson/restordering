/*
ItemRepositoryTest.java
ItemRepositoryTest
Author Craig Jarvis (220103216)
Date: 9 April 2022
 */

package za.ac.cput.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Item;
import za.ac.cput.factory.ItemFactory;

@TestMethodOrder(MethodOrderer.MethodName.class)
class ItemRepositoryTest {
    private static ItemRepository repository
            = ItemRepository.getRepository();
    private static Item item =
            ItemFactory.createItem(1, 46, 57, 67.99);
    private static Item item2 =
            ItemFactory.createItem(2, 13, 89, 42.50);

    @Test
    void a_create() {
        Item created = repository.create(item);
        assertEquals(item.getID(), item.getID());
        System.out.println("Order: " + item);
    }

    @Test
    void a_create2(){
        Item created = repository.create(item2);
        assertEquals(item.getID(), item.getID());
        System.out.println("Order: " + item);
    }

    @Test
    void b_read() {
        Item read = repository.read(item.getID());
        assertNotNull(read);
        System.out.println("Read:" + read);
    }

    @Test
    void c_update() {
        Item updated = new
                Item.Builder().copy(item)
                .setID(20)
                .setOrderID(45)
                .setQuantity(67)
                .setPrice(89.99)
                .build();
        System.out.println("Updated: " + updated);
    }

    @Test
    void d_delete() {
        boolean success = repository.delete(item.getOrderID().toString());
        System.out.println("Deleted: " + success);
    }

    @Test
    void e_getAll() {
        System.out.println("Show all: ");
        System.out.println(repository.getAll());
    }
}