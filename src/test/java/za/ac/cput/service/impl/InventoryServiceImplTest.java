/*

Author: Shuaib Allie 217148867

 */

package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.entity.Inventory;
import za.ac.cput.factory.InventoryFactory;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class InventoryServiceImplTest {

    @Autowired
    private InventoryServiceImpl service;
    private final Inventory inventory1= InventoryFactory.createInventory("012","Chicken Gatsby","Gatsby","Johnston", 30, 65);
    private final Inventory inventory2 =InventoryFactory.createInventory("013","Chicken Sandwich", "Sandwich", "Ibrahims", 25, 40);

    @Test
    @Order(1)
    void save() {
        Inventory create1=this.service.save(inventory1);
        Inventory create2= this.service.save(inventory2);
        assertNotNull(create1);
        assertNotNull(create2);


        System.out.println(create1);
        System.out.println(create2);
        System.out.println();
    }

    @Test
    @Order(2)
    void findById() {
        Optional<Inventory> read =this.service.findById(inventory2.getInv());
        System.out.println(read);
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertNotEquals(this.inventory1, read.get())
        );

        System.out.println();
    }

    @Test
    @Order(4)
    void delete() {
        service.delete(inventory1);
        List<Inventory> listInventory=this.service.findAll();
        System.out.println(listInventory);
        assertEquals(1,listInventory.size());
        System.out.println();
    }

    @Test
    @Order(3)
    void findAll() {
        List<Inventory> listInventory= this.service.findAll();
        System.out.println(listInventory);
        assertEquals(2,listInventory.size());
        System.out.println();

    }

    @Test
    @Order(5)
    void deleteById() {
        service.deleteById("013");
        List<Inventory> listInventory=this.service.findAll();

        System.out.println(listInventory);
    }
}
