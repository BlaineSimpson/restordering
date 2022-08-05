/*

Author Shuaib Allie

 */

package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Inventory;

import static org.junit.jupiter.api.Assertions.*;

class InventoryFactoryTest {

    @Test
    void createInventory() {
        Inventory inventory= InventoryFactory.createInventory("1A","Beef burger","Burgers", "Johnston", 20, 34);
        assertNotNull(inventory);
        System.out.println("Create Inventory ");
        System.out.println(inventory);
        System.out.println("Inventory added....");
    }


}