package za.ac.cput.repository;

import za.ac.cput.entity.Menu;

import java.util.Set;
/* IMenuRepository.java
 Entity for the Menu
 Author: Blaine Simpson (218020171)
 Date: 02 April 2022

 */
public interface IMenuRepository extends IRepository<Menu, String> {

    public Set<Menu> getAll();

    //create,update,read,delete

}
