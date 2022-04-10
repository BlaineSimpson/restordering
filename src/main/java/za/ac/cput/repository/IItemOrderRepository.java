package za.ac.cput.repository;

import za.ac.cput.entity.ItemOrder;

import java.util.Set;
/* IItemOrderRepository.java
 Entity for the ItemOrder
 Author: Blaine Simpson (218020171)
 Date: 01 April 2022

 */

public interface IItemOrderRepository extends IRepository<ItemOrder,String>{
    public Set<ItemOrder> getAll();
//create,update,read,delete
}
