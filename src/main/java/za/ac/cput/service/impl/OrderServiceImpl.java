/*
Order Service Impl
OrderServiceImpl entity
Author Craig Jarvis (220103216)
Date: 25 September 2022
 */

package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Order;
import za.ac.cput.repository.IOrderRepository;
import za.ac.cput.service.IOrderService;

import java.util.List;
import java.util.Optional;

public class OrderServiceImpl implements IOrderService {

    private final IOrderRepository repository;

    @Autowired
    public OrderServiceImpl(IOrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public Order save(Order order) {
        return this.repository.save(order);
    }

    @Override
    public Optional<Order> findById(String id) {
        return this.repository.findById(id);
    }

    @Override
    public void delete(Order order) {
        this.repository.delete(order);
    }

    @Override
    public List<Order> findAll() {
        return this.repository.findAll();
    }

    @Override
    public void deleteById(String id) {
        Optional<Order> order = findById(id);
        order.ifPresent(this::delete);
    }
}
