package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Menu;

import static org.junit.jupiter.api.Assertions.*;

class MenuFactoryTest {
    /* MenuFactoryTest.java
     Entity for the Menu
     Author: Blaine Simpson (218020171)
     Date: 02 April 2022

     */
    @Test
    void createMenu() {
        Menu menu = MenuFactory.createMenu("A","L");
        System.out.println(menu);
        assertNotNull(menu);

    }
}