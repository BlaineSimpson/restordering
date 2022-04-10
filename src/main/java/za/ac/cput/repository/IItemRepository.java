package za.ac.cput.repository;

import za.ac.cput.entity.Item;

import java.util.Set;
/* IItemRepository.java
 Entity for the Item
 Author: Blaine Simpson (218020171)
 Date: 01 April 2022

 */

public interface IItemRepository extends IRepository<Item,String>{
    public Set<Item> getAll();
//create,update,read,delete
}
