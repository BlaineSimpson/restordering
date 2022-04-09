package za.ac.cput.repository;

import za.ac.cput.entity.Order;
import java.util.Set;

public interface IOrderRepository extends IRepository<Order,String> {
    public Set<Order> getAll();
}
