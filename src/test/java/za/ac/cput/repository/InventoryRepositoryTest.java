package za.ac.cput.repository;


/*
IRepository.java
Author: Shuaib Allie (217148867)
Date: 1 April 2022
 */

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Inventory;
import za.ac.cput.factory.InventoryFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class InventoryRepositoryTest {

    private static InventoryRepository repository
            = InventoryRepository.getRepository();
    private static Inventory inventory=
            InventoryFactory.createInventory("Chicken", "Tacos", "Food", "Wholesaler", 5000, 50);
    private static Inventory inventory2=
            InventoryFactory.createInventory("Chicken", "Tacos", "Food", "Wholesaler", 5000, 50);


    @Test
    void a_create() {
        Inventory created = repository.create(inventory);
        assertEquals(inventory.getInv(), created.getInv());
        System.out.println("Create: " + created);
    }

    @Test
    void a_create2(){
        Inventory created = repository.create(inventory2);
        assertEquals(inventory.getInv(), created.getInv());
        System.out.println("Create: " + created);
    }

    @Test
    void b_read(){
        Inventory read = repository.read(inventory.getInv());
        assertNotNull(read);
        System.out.println("Read:" +read);
    }

    @Test
    void c_update() {
        Inventory updated = new
                Inventory.Builder().copy(inventory)
                    .setItemName("Tacos")
                .setCategory("Food")
                .setVendor("Butcher")
                .setVendorInv(250)
                .setVendorPrice(45)
                    .build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void d_delete(){
        boolean success = repository.delete(inventory.getInv());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Test

    void e_getAll(){
        System.out.println("Show all: ");
        System.out.println(repository.getAll());
    }
}