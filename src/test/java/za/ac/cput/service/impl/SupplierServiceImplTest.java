/*

Author: Shuaib Allie 217148867

 */

package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Supplier;
import za.ac.cput.factory.SupplierFactory;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SupplierServiceImplTest {

    @Autowired
    private SupplierServiceImpl service;
    private final Supplier supplier1= SupplierFactory.createSupplier("Cape Shop","2 Hole Street","capeshop@gmail.com","21458221", "35B");
    private final Supplier supplier2 =SupplierFactory.createSupplier("Corner Shop","38 Beek Street", "cornershop@gmail.com", "2487541", "28D");

    @Test
    @Order(1)
    void save() {
        Supplier create1=this.service.save(supplier1);
        Supplier create2= this.service.save(supplier2);
        assertNotNull(create1);
        assertNotNull(create2);


        System.out.println(create1);
        System.out.println(create2);
        System.out.println();
    }

    @Test
    @Order(2)
    void findById() {
        Optional<Supplier> read =this.service.findById(supplier2.getSuppName());
        System.out.println(read);
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertNotEquals(this.supplier1, read.get())
        );

        System.out.println();
    }

    @Test
    @Order(4)
    void delete() {
        service.delete(supplier1);
        List<Supplier> listSupplier=this.service.findAll();
        System.out.println(listSupplier);
        assertEquals(2,listSupplier.size());
        System.out.println();
    }

    @Test
    @Order(3)
    void findAll() {
        List<Supplier> listSupplier= this.service.findAll();
        System.out.println(listSupplier);
        assertEquals(1,listSupplier.size());
        System.out.println();

    }

    @Test
    @Order(5)
    void deleteById() {
        service.deleteById("013");
        List<Supplier> listSupplier=this.service.findAll();

        System.out.println(listSupplier);
    }
}

