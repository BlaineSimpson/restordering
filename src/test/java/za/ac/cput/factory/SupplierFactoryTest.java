/*

Author Shuaib Allie

 */

package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Supplier;

import static org.junit.jupiter.api.Assertions.*;

class SupplierFactoryTest {

    @Test
    void createSupplier() {
        Supplier supplier= SupplierFactory.createSupplier("22D","2 Unity Road","davids34@gmail.com","021457457", "Transnet");
        assertNotNull(supplier);
        System.out.println("Create Supplier ");
        System.out.println(supplier);
        System.out.println("Supplier added....");
    }


}