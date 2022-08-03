/*
ITableRepository.java
Author Demi Alexis Farquhar (220322104)
Date:  April 2022
 */
package za.ac.cput.repository;

import za.ac.cput.entity.Table;

import java.util.Set;

public interface ITableRepository extends IRepository<Table,String>{
    //create, read, update, delete
    public Set<Table> getAll();
}
