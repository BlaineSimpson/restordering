package za.ac.cput.repository;
/* Bill.java
 Entity for the Bill
 Author: Sinovuyo Mlanjeni (219220387)
 Date: 04 April 2022
*/

import za.ac.cput.entity.Bill;
import java.util.Set;


public interface IBillRepository extends IRepository<Bill, String>{
    public Set<Bill> getAll();
}



