package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.ItemOrder;
import za.ac.cput.factory.ItemOrderFactory;

import static org.junit.jupiter.api.Assertions.*;
/* IItemOrderRepositoryTest.java
 Entity for the ItemOrder
 Author: Blaine Simpson (218020171)
 Date: 02 April 2022

 */
@TestMethodOrder(MethodOrderer.MethodName.class)
class ItemRepositoryOrderTest {
    private static ItemRepository  repository
            =ItemRepository.getRespository();
    private static ItemOrder item =
            ItemOrderFactory.createItem("1","Pizza","5");


    @Test
    void a_create() {
        ItemOrder created = repository.create(item);
        assertEquals(item.getItemId(), created.getItemId());
        System.out.println("Create: "+ created);
    }

    @Test
    void b_read() {
       ItemOrder read = repository.read(item.getItemId());
       assertNotNull(read);
        System.out.println("Read:" +read);

    }

    @Test
    void c_update() {
        ItemOrder updated = new
                ItemOrder.Builder().copy(item)
                .setItemName("Hotdog")
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