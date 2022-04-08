package za.ac.cput.factory;

/*
IRepository.java
Author: Shuaib Allie (217148867)
Date: 1 April 2022
 */

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Supplier;

import static org.junit.jupiter.api.Assertions.*;

class SupplierFactoryTest {
@Test
    void createSupplier(){
    Supplier supplier = SupplierFactory.createSupplier("Corner Butcher", "4 Adams Avenue, Cape Town", "cornerbuther@gmail.com", 0241245632, 254);
    System.out.println(supplier);
    assertNotNull(supplier);
}
}