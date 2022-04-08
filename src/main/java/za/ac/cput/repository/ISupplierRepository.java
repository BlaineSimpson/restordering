package za.ac.cput.repository;

/*
IRepository.java
Author: Shuaib Allie (217148867)
Date: 1 April 2022
 */

import za.ac.cput.entity.Supplier;

import java.util.Set;

public interface ISupplierRepository extends IRepository <Supplier, String> {
    public Set<Supplier> getAll();
}
