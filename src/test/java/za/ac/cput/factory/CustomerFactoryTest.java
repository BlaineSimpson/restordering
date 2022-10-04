package za.ac.cput.factory;
/* Customer.java
 Entity for the Customer
 Author: Sinovuyo Mlanjeni (219220387)
 Date: 04 April 2022
*/

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Customer;
import static org.junit.jupiter.api.Assertions.*;


class CustomerFactoryTest {
    @Test
    void createCustomer() {
        Customer customer = CustomerFactory.createCustomer("57522", "Mike", "Williams", "586852@cput.ac.za", "1 Hofmayr Lane, Cape Town");
        System.out.println(customer);
        assertNotNull(customer);
    }


}