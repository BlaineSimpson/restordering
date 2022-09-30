/* Customer.java
  Interface service for  Customer
   Author: Sinovuyo Mlanjeni (219220387)
    Date: 05 August 2022
  */
package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.entity.Customer;

import za.ac.cput.factory.CustomerFactory;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CustomerServiceImplTest {
    @Autowired
    private CustomerServiceImpl service;
    private final Customer customer1 = CustomerFactory.createCustomer("57522", "Mike", "Williams", "586852@cput.ac.za", "1 Hofmayr Lane, Cape Town");
    private final Customer customer2 = CustomerFactory.createCustomer("252", "Blue", "Timothy", "25146@cput.ac.za", "254 Delft Laiden");

    @Test
    @Order(1)
    void save() {
        Customer create1=this.service.save(customer1);
        Customer create2= this.service.save(customer2);
        assertNotNull(create1);
        assertNotNull(create2);


        System.out.println(create1);
        System.out.println(create2);
        System.out.println();
    }
    @Test
    @Order(2)
    void findById() {
        Optional<Customer> read =this.service.findById(customer2.getCusId());
        System.out.println(read);
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertNotEquals(this.customer1, read.get())
        );

        System.out.println();
    }
    @Test
    @Order(4)
    void delete() {
        service.delete(customer1);
        List<Customer> listCustomer=this.service.findAll();
        System.out.println(listCustomer);
        assertEquals(1,listCustomer.size());
        System.out.println();
    }

    @Test
    @Order(3)
    void findAll() {
        List<Customer> listCustomer= this.service.findAll();
        System.out.println(listCustomer);
        assertEquals(2,listCustomer.size());
        System.out.println();

    }

    @Test
    @Order(5)
    void deleteById() {
        service.deleteById("252");
        List<Customer> listCustomer=this.service.findAll();

        System.out.println(listCustomer);
    }

}