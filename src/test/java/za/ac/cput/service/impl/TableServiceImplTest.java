/*
TableServiceImplTest.java
Author Demi Alexis Farquhar (220322104)
Date: 5 August 2022
 */
package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.entity.Tablee;
import za.ac.cput.factory.TableFactory;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TableServiceImplTest {

    @Autowired
    private TableServiceImpl service;
    private final Tablee table= TableFactory.createTable("012C","12","10",true);
    private final Tablee table1= TableFactory.createTable("021B","5","2",true);

    @Test
    @Order(1)
    void save() {
        Tablee create= this.service.save(table);
        Tablee create1=this.service.save(table1);
        assertNotNull(create);
        assertNotNull(create1);
        System.out.println(create);
        System.out.println(create1);
 System.out.println();
    }

    @Test
    @Order(2)
    void findById() {
        Optional<Tablee> read =this.service.findById(table.getTableId());
        System.out.println(read);
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertNotEquals(this.table1, read.get())
        );

        System.out.println();
    }

    @Test
    @Order(4)
    void delete() {
        service.delete(table);
        List<Tablee> listTable=this.service.findAll();
        System.out.println(listTable);
        assertEquals(1,listTable.size());
        System.out.println();
    }

    @Test
    @Order(3)
    void findAll() {
        List<Tablee> listTable= this.service.findAll();
        System.out.println(listTable);
        assertEquals(2,listTable.size());
        System.out.println();
    }

    @Test
    @Order(5)
    void deleteById() {
        service.deleteById("021B");
        List<Tablee> listTable=this.service.findAll();

        System.out.println(listTable);
    }
}