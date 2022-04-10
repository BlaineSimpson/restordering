/*
OrderRepository.java
OrderRepository entity
Author Craig Jarvis (220103216)
Date: 9 April 2022
 */

package za.ac.cput.repository;

import za.ac.cput.entity.Order;
import java.util.HashSet;
import java.util.Set;

public class OrderRepository {
    private static OrderRepository repository=null;
    private Set<Order> orderDB =null;

    private OrderRepository(){
        orderDB =new HashSet<Order>();
    }
    public static OrderRepository getRepository(){
        if(repository==null){
            repository= new OrderRepository();
        }
        return repository;
    }

    //@Override
    public Order create(Order order) {
        boolean success= orderDB.add(order);
        if(!success)
            return null;
        return order;
    }

    //@Override
    public Order read(String s) {
        return null;
    }

    //@Override
    public Order read(Integer orderId) {
        Order order= orderDB.stream()
                .filter(r->r.getCustomerID().equals(orderId))
                .findAny()
                .orElse(null);
        return order;
    }

    //@Override
    public Order update(Order order) {
        Order oldOrder= read(order.getCustomerID());
        if(oldOrder != null){
            orderDB.remove(oldOrder);
            orderDB.add(order);
            return order;
        }
        return null;
    }

    //@Override
    public boolean delete(String orderId) {
        Order orderToDelete=read(orderId);
        if(orderToDelete== null)
            return false;
        orderDB.remove(orderToDelete);
        return true;
    }

    //@Override
    public Set<Order> getAll() {
        return orderDB;
    }
}
