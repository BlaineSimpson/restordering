package za.ac.cput.repository;

import za.ac.cput.entity.ItemOrder;

import java.util.HashSet;
import java.util.Set;
/* ItemOrderRepository.java
 Entity for the ItemOrder
 Author: Blaine Simpson (218020171)
 Date: 01 April 2022

 */
public class ItemRepository implements IItemOrderRepository {

    private static ItemRepository repository =null;
    private Set<ItemOrder> itemDB=null;

    private ItemRepository() {

     itemDB = new HashSet<ItemOrder>();

    }

    public static ItemRepository getRespository() {

        if (repository == null){
            repository = new ItemRepository();
        }

        return repository;
    }





    @Override
    public ItemOrder read(String ItemId) {
        ItemOrder item = itemDB.stream()
                .filter(i-> i.getItemId().equals(ItemId))
                .findAny()
                .orElse(null);
        return item;
}


    @Override
    public ItemOrder update(ItemOrder item) {
        ItemOrder oldItem = read (item.getItemId());
        if(oldItem !=null) {
            itemDB.remove(oldItem);
            itemDB.add(item);
            return item;
        }
        return null;

    }

    @Override
    public boolean delete(String ItemId) {
        ItemOrder itemDelete = read(ItemId);
        if (itemDelete == null)
            return false;
        itemDB.remove(itemDelete);

      return true ;
    }
    @Override
    public ItemOrder create(ItemOrder item) {

    boolean works = itemDB.add(item);

    if (!works)
        return null;
    return item;

    }
    @Override
    public Set<ItemOrder> getAll() {
        return itemDB;
    }
}
