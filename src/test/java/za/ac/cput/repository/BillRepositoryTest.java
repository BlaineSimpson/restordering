package za.ac.cput.repository;
/* Bill.java
 Entity for the Bill
 Author: Sinovuyo Mlanjeni (219220387)
 Date: 04 April 2022
*/
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Bill;
import za.ac.cput.factory.BillFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class BillRepositoryTest {
    private static BillRepository repository
            = BillRepository.getRepository();
    private static Bill bill=
            BillFactory.createBill("B2185", "25 April 2021", "2254", "RE2251", "Paid cash", 550);
    private static Bill bill2=
            BillFactory.createBill("B2185", "11 jUNE 2021", "1222", "RE2251", "Paid with credit", 220);

    @Test
    void a_create() {
        Bill created = repository.create(bill);
        assertEquals(bill.getBillId(), created.getBillId());
        System.out.println("Create: " + created);
    }

    @Test
    void a_create2(){
        Bill created = repository.create(bill2);
        assertEquals(bill.getBillId(), created.getBillId());
        System.out.println("Create: " + created);

    }
    @Test
    void b_read(){
        Bill read = repository.read(bill.getBillId());
        assertNotNull(read);
        System.out.println("Read:" +read);
    }

    @Test
    void c_update() {
        Bill updated = new
                Bill.Builder().copy(bill)
                .setBillId("B2185")
                .setBillDate("25 April 2021")
                .setCusId("2254")
                .setRestaurantId("RE2251")
                .setBillDescr("Paid cash")
                .setBillAmount(550)
                .build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void d_delete(){
        boolean success = repository.delete(bill.getBillId());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Test

    void e_getAll(){
        System.out.println("Show all: ");
        System.out.println(repository.getAll());
    }
}



