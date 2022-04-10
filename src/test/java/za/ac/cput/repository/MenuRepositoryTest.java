package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Menu;
import za.ac.cput.factory.MenuFactory;

import static org.junit.jupiter.api.Assertions.*;
/* MenuRepositoryTest.java
 Entity for the Menu
 Author: Blaine Simpson (218020171)
 Date: 02 April 2022

 */
@TestMethodOrder(MethodOrderer.MethodName.class)
class MenuRepositoryTest {
private static MenuRepository repository
        =MenuRepository.getRespository();
    private  static Menu menu =
            MenuFactory.createMenu("1","Kids");

    @Test
    void a_create() {
        Menu created = repository.create(menu);
        assertEquals(menu.getMenuId(), created.getMenuId());
        System.out.println("Create" + created);
    }
    @Test
    void b_read() {
        Menu read = repository.read(menu.getMenuT());
        assertNotNull(read);
        System.out.println("Read:"  +read);
    }

    @Test
    void c_update() {
         Menu updated = new
                Menu.Builder().copy(menu)
                 .setMenuId("10")
                 .setMenuT("Adults")
                 .build();
                 assertNotNull (repository);
                 System.out.println(" Updated completed: " + updated );
    }

    @Test
    void d_delete() {
    boolean works = repository.delete(menu.getMenuT());
         assertTrue(works);
        System.out.println("Deleted" + works);
    }



    @Test
    void e_getAll() {
        System.out.println("Display:");
        System.out.println(repository.getAll());
    }
}