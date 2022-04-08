package za.ac.cput.repository;

/*
IRepository.java
Author: Shuaib Allie (217148867)
Date: 1 April 2022
 */

import za.ac.cput.entity.Inventory;

import java.util.HashSet;
import java.util.Set;

public class InventoryRepository implements IInventoryRepository {
    private static InventoryRepository repository=null;
    private Set<Inventory> inventoryDB=null;

    private InventoryRepository(){
        inventoryDB = new HashSet<Inventory>();
    }

    public static InventoryRepository getRepository() {
        if (repository == null) {
            repository = new InventoryRepository();
        }
        return repository;
    }
    @Override
    public Inventory create (Inventory inventory){
        boolean success = inventoryDB.add(inventory);

        if(!success)
            return null;
        return inventory;
    }

    @Override
    public Inventory read(String inv){
        Inventory inventory = inventoryDB.stream()
                .filter(i-> i.getInv().equals(inv))
                .findAny()
                .orElse(null);

                return inventory;
    }

    @Override
    public Inventory update(Inventory inventory){
        Inventory oldInventory=read(inventory.getInv());
        if(oldInventory !=null){
            inventoryDB.remove(oldInventory);
            inventoryDB.add(inventory);
            return inventory;
        }
        return null;
    }

    @Override

    public boolean delete(String inv) {
        Inventory inventoryToDelete=read(inv);
        if(inventoryToDelete == null)
            return false;

        inventoryDB.remove(inventoryToDelete);

        return true;
    }

    @Override
    public Set<Inventory> getAll(){
        return inventoryDB;
    }
}
