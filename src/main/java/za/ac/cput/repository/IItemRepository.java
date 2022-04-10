package za.ac.cput.repository;

import za.ac.cput.entity.Item;
import java.util.Set;

public interface IItemRepository extends IRepository<Item,String> {
    public Set<Item> getAll();
}
