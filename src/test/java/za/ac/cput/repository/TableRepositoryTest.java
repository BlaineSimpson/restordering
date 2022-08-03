/*
TableRepositoryTest.java
Author Demi Alexis Farquhar (220322104)
Date: 6 April 2022
 */

package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Table;
import za.ac.cput.factory.TableFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
class TableRepositoryTest {
    private static TableRepository repository= TableRepository.getRepository();
    private static Table table= TableFactory.createTable("02A",3,10,true);

    @Test
    void a_create() {
        Table created= repository.create(table);
        assertEquals(table.getTableId(),created.getTableId());
        System.out.println("Create table:");
        System.out.println(created);
        System.out.println();

    }

    @Test
    void b_read() {
        Table read=repository.read(table.getTableId());
        assertNotNull(read);
        System.out.println("Read table: ");
        System.out.println(read);
        System.out.println();
    }

    @Test
    void c_update() {
        Table updated= new Table.Builder().copy(table).setTableAvailable(false).build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated Version of table: ");
        System.out.println(updated);
        System.out.println();
    }

    @Test
    void e_delete() {
        boolean success=repository.delete(table.getTableId());
        assertTrue(success);
        System.out.println("Delete table" );
        System.out.println(success);
        System.out.println();
    }

    @Test
    void d_getAll() {
        System.out.println("Show all Tables:");
        System.out.println(repository.getAll());
        System.out.println();
    }
}