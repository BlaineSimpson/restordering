/* Bill.java

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
import za.ac.cput.entity.AdminLogin;
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
        Bill create = this.service.save(bill1);
        Bill create2 = this.service.save(bill2);
        assertNotNull(create);
        assertNotNull(create2);
        System.out.println(create);
    }
    @Test
    @Order(2)
    void findById() {
            Optional<Bill> read = this.service.findById(this.bill1.getBillId());
            assertAll(
                    () -> assertTrue(read.isPresent()),
                    () -> assertEquals(this.bill1, read.get())
            );
            System.out.println(read);
    }
    @Test
    @Order(4)
    void delete() {
        service.delete(bill1); //delete admin 1
        List<Bill> list = this.service.findAll();
        System.out.println(list);
    }

    @Test
    @Order(3)
    void findAll() {
        List<Bill> list = this.service.findAll();
        System.out.println(list);

    }

    @Test
    @Order(5)
    void deleteById() {
        service.deleteById("252"); //Deleted admin 2 (List should be empty)
        List<Bill> list = this.service.findAll();
        System.out.println(list);
    }


}