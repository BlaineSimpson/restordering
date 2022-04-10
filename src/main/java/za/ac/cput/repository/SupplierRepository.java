package za.ac.cput.repository;

/*
IRepository.java
Author: Shuaib Allie (217148867)
Date: 1 April 2022
 */

import za.ac.cput.entity.Supplier;

import java.util.HashSet;
import java.util.Set;

public class SupplierRepository implements ISupplierRepository {
    private static SupplierRepository repository=null;
    private Set<Supplier> supplierDB=null;

    private SupplierRepository(){
        supplierDB = new HashSet<Supplier>();
    }

    public static SupplierRepository getRepository() {
        if (repository == null) {
            repository = new SupplierRepository();
        }
        return repository;
    }
    @Override
    public Supplier create (Supplier supplier){
        boolean success = supplierDB.add(supplier);

        if(!success)
            return null;
        return supplier;
    }

    @Override
    public Supplier read(String suppName){
        Supplier supplier = supplierDB.stream()
                .filter(i-> i.getSuppName().equals(suppName))
                .findAny()
                .orElse(null);

        return supplier;
    }

    @Override
    public Supplier update(Supplier supplier){
        Supplier oldInventory=read(supplier.getSuppName());
        if(oldInventory !=null){
            supplierDB.remove(oldInventory);
            supplierDB.add(supplier);
            return supplier;
        }
        return null;
    }

    @Override

    public boolean delete(String suppName) {
        Supplier inventoryToDelete=read(suppName);
        if(inventoryToDelete == null)
            return false;

        supplierDB.remove(inventoryToDelete);

        return true;
    }

    @Override
    public Set<Supplier> getAll(){
        return supplierDB;
    }
}

