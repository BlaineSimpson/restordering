package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Item;
import za.ac.cput.factory.ItemFactory;

import static org.junit.jupiter.api.Assertions.*;
/* IItemRepositoryTest.java
 Entity for the Item
 Author: Blaine Simpson (218020171)
 Date: 01 April 2022

 */
@TestMethodOrder(MethodOrderer.MethodName.class)
class ItemRepositoryTest {
    private static ItemRepository  repository
            =ItemRepository.getRespository();
    private static Item item =
            ItemFactory.createItem("1","Pizza","200");


    @Test
    void a_create() {
        Item created = repository.create(item);
        assertEquals(item.getItemId(), created.getItemId());
        System.out.println("Create: "+ created);
    }

    @Test
    void b_read() {
       Item read = repository.read(item.getItemId());
       assertNotNull(read);
        System.out.println("Read:" +read);

    }

    @Test
    void c_update() {
        Item updated = new
                Item.Builder().copy(item)
                .setItemName("Hotdog")
                .setPrice("80")
                .build();
        assertNotNull(repository);
        System.out.println(" Update completed: "+updated  );
    }

    @Test
    void d_delete() {
        boolean works =repository.delete(item.getItemId());
        assertTrue(works);
        System.out.println("Deleted" + works);
    }



    @Test
    void e_getAll() {
        System.out.println("Display all");
        System.out.println(repository.getAll());
    }
}