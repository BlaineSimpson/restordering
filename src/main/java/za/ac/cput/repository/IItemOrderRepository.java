package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.ItemOrder;

import java.util.Set;
/* IItemOrderRepository.java
 Entity for the ItemOrder
 Author: Blaine Simpson (218020171)


 */
@Repository
public interface IItemOrderRepository extends JpaRepository<ItemOrder,String> {
//create,update,read,delete
}
