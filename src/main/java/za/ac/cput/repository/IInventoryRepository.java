package za.ac.cput.repository;

/*
IRepository.java
Author: Shuaib Allie (217148867)
Date: 1 April 2022
 */

import za.ac.cput.entity.Inventory;

import java.util.Set;

public interface IInventoryRepository extends IRepository <Inventory, String> {
    public Set<Inventory> getAll();
}
