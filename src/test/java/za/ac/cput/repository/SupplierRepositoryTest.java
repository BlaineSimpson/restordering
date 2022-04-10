package za.ac.cput.repository;


/*
IRepository.java
Author: Shuaib Allie (217148867)
Date: 1 April 2022
 */

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Supplier;
import za.ac.cput.factory.SupplierFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class SupplierRepositoryTest {

    private static SupplierRepository repository
            = SupplierRepository.getRepository();
    private static Supplier supplier =
            SupplierFactory.createSupplier("The Butcher", "28 John Avenue, Cape Town", "thebuther@gmail.com", 0214532315, 214);
    private static Supplier supplier2 =
            SupplierFactory.createSupplier("The Butcher", "28 John Avenue, Cape Town", "thebuther@gmail.com", 0214532315, 214);

    @Test
    void a_create() {
        Supplier created = repository.create(supplier);
        assertEquals(supplier.getSuppName(), created.getSuppName());
        System.out.println("Create: " + created);
    }

    @Test
    void a_create2(){
        Supplier created = repository.create(supplier2);
        assertEquals(supplier.getSuppName(), created.getSuppName());
        System.out.println("Create: " + created);
    }

    @Test
    void b_read() {
        Supplier read = repository.read(supplier.getSuppName());
        assertNotNull(read);
        System.out.println("Read:" + read);
    }

    @Test
    void c_update() {
        Supplier updated = new
                Supplier.Builder().copy(supplier)
                .setSuppPhysAddress("28 John Avenue, Cape Town")
                .setSupEmail("butherjohn@gmail.com")
                .setSupPhone(0214561231)
                .setSuppID(457)
                .build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void d_delete() {
        boolean success = repository.delete(supplier.getSuppName());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Test
    void e_getAll() {
        System.out.println("Show all: ");
        System.out.println(repository.getAll());
    }

}