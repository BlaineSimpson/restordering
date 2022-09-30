package za.ac.cput.repository;
/* Bill.java
 Entity for the Bill
 Author: Sinovuyo Mlanjeni (219220387)
 Date: 04 April 2022
*/

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.entity.Bill;
import java.util.Set;


public interface IBillRepository extends JpaRepository<Bill, String> {
    public Set<Bill> getAll();
}



