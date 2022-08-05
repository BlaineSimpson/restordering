/*
TableFactoryTest.java
Author Demi Alexis Farquhar (220322104)
Date: 7 April 2022
 */

package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Tablee;

import static org.junit.jupiter.api.Assertions.*;

class TableFactoryTest {

    @Test
    void createTable(){
        Tablee table= TableFactory.createTable("021A","2","1",true);
        assertNotNull(table);
        System.out.println("Create Table");
        System.out.println(table);
        System.out.println("Table added......");
    }

}