package za.ac.cput.repository;
/* Bill.java
 Entity for the Bill
 Author: Sinovuyo Mlanjeni (219220387)
 Date: 04 April 2022
*/

import za.ac.cput.entity.Customer;
import java.util.Set;

public interface ICustomerRepository extends IRepository <Customer, String> {
    public Set<Customer> getAll();


}
