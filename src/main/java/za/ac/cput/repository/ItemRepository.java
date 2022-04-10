/*
ItemRepository.java
ItemRepository entity
Author Craig Jarvis (220103216)
Date: 9 April 2022
 */

package za.ac.cput.repository;

import za.ac.cput.entity.Item;
import java.util.HashSet;
import java.util.Set;


public class ItemRepository implements IItemRepository {
    private static ItemRepository repository=null;
    private Set<Item> itemDB =null;

    private ItemRepository(){
        itemDB =new HashSet<Item>();
    }
    public static ItemRepository getRepository(){
        if(repository==null){
            repository= new ItemRepository();
        }
        return repository;
    }

    @Override
    public Item create(Item item) {
        boolean success= itemDB.add(item);
        if(!success)
            return null;
        return item;
    }

    @Override
    public Item read(String s) {
        return null;
    }

    //@Override
    public Item read(Integer itemId) {
        Item item= itemDB.stream()
                .filter(r->r.getID().equals(itemId))
                .findAny()
                .orElse(null);
        return item;
    }

    @Override
    public Item update(Item item) {
        Item oldItem= read(item.getID());
        if(oldItem != null){
            itemDB.remove(oldItem);
            itemDB.add(item);
            return item;
        }
        return null;
    }

    @Override
    public boolean delete(String itemId) {
        Item itemToDelete=read(itemId);
        if(itemToDelete== null)
            return false;
        itemDB.remove(itemToDelete);
        return true;
    }

    @Override
    public Set<Item> getAll() {
        return itemDB;
    }
}
