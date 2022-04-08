package za.ac.cput.factory;

/*
IRepository.java
Author: Shuaib Allie (217148867)
Date: 1 April 2022
 */

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Inventory;

import static org.junit.jupiter.api.Assertions.*;

class InventoryFactoryTest {
@Test
    void createInventory(){
    Inventory inventory = InventoryFactory.createInventory("Beef","Burger", "Food", "Wholesaler", 1000, 60);
    System.out.println(inventory);
    assertNotNull(inventory);

}
}