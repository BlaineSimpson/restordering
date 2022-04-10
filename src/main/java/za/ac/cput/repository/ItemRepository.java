package za.ac.cput.repository;

import za.ac.cput.entity.Item;

import java.util.HashSet;
import java.util.Set;
/* ItemRepository.java
 Entity for the Item
 Author: Blaine Simpson (218020171)
 Date: 01 April 2022

 */
public class ItemRepository implements IItemRepository {

    private static ItemRepository repository =null;
    private Set<Item> itemDB=null;

    private ItemRepository() {

     itemDB = new HashSet<Item>();

    }

    public static ItemRepository getRespository() {

        if (repository == null){
            repository = new ItemRepository();
        }

        return repository;
    }





    @Override
    public Item read(String ItemId) {
        Item item = itemDB.stream()
                .filter(i-> i.getItemId().equals(ItemId))
                .findAny()
                .orElse(null);
        return item;
}


    @Override
    public Item update(Item item) {
        Item oldItem = read (item.getItemId());
        if(oldItem !=null) {
            itemDB.remove(oldItem);
            itemDB.add(item);
            return item;
        }
        return null;

    }

    @Override
    public boolean delete(String ItemId) {
        Item itemDelete = read(ItemId);
        if (itemDelete == null)
            return false;
        itemDB.remove(itemDelete);

      return true ;
    }
    @Override
    public Item create(Item item) {

    boolean works = itemDB.add(item);

    if (!works)
        return null;
    return item;

    }
    @Override
    public Set<Item> getAll() {
        return itemDB;
    }
}
