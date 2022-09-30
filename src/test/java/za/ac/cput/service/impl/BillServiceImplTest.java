/* Bill.java
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
import za.ac.cput.entity.Bill;
import za.ac.cput.factory.BillFactory;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BillServiceImplTest {
    @Autowired
    private BillServiceImpl service;
    private final Bill bill1 = BillFactory.createBill("6682", "22 June 2021","5887", " R458", " Paid with cash", 658);
    private final Bill bill2 = BillFactory.createBill("6682", "22 June 2021","5887", " R458", " Paid with cash", 658);

    @Test
    @Order(1)
    void save() {
        Bill create1=this.service.save(bill1);
        Bill create2=this.service.save(bill1);
        assertNotNull(create1);
        assertNotNull(create2);


        System.out.println(create1);
        System.out.println(create2);
        System.out.println();
    }
    @Test
    @Order(2)
    void findById() {
        Optional<Bill> read =this.service.findById(bill2.getCusId());
        System.out.println(read);
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertNotEquals(this.bill1, read.get())
        );

        System.out.println();
    }
    @Test
    @Order(4)
    void delete() {
        service.delete(bill1);
        List<Bill> listBill=this.service.findAll();
        System.out.println(listBill);
        assertEquals(1,listBill.size());
        System.out.println();
    }

    @Test
    @Order(3)
    void findAll() {
        List<Bill> listBill= this.service.findAll();
        System.out.println(listBill);
        assertEquals(2,listBill.size());
        System.out.println();

    }

    @Test
    @Order(5)
    void deleteById() {
        service.deleteById("252");
        List<Bill> listBill=this.service.findAll();

        System.out.println(listBill);
    }


}