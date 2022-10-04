package za.ac.cput.factory;
/* Bill.java
 Entity for the Bill
 Author: Sinovuyo Mlanjeni (219220387)
 Date: 04 April 2022
*/


import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Bill;
import static org.junit.jupiter.api.Assertions.*;

class BillFactoryTest {
    @Test
    void createBill(){
        Bill bill = BillFactory.createBill("6682", "22 June 2021","5887", " R458", " Paid with cash", 658);
        System.out.println(bill);
        assertNotNull(bill);
    }



}