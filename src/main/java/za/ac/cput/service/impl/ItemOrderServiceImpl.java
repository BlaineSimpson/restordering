package za.ac.cput.service.impl;
/* ItemOrderImpl.java
 Entity for the ItemOrder
 Author: Blaine Simpson (218020171)


 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Item;
import za.ac.cput.entity.ItemOrder;
import za.ac.cput.repository.IItemOrderRepository;
import za.ac.cput.service.IItemOrderService;

import java.util.List;
import java.util.Optional;


@Service
public class ItemOrderServiceImpl implements IItemOrderService {


    private final IItemOrderRepository repository;

    @Autowired
    public ItemOrderServiceImpl(IItemOrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public ItemOrder save(ItemOrder itemOrder) {
        return this.repository.save(itemOrder);
    }

    @Override
    public Optional<ItemOrder> findById(String id) {
        return this.repository.findById(id);
    }

    @Override
    public void delete(ItemOrder itemOrder) {
        this.repository.delete(itemOrder);

    }

    @Override
    public List<ItemOrder> findAll() {
        return this.repository.findAll();
    }

    @Override
    public void deleteById(String id) {
    Optional<ItemOrder> itemOrder = findById(id);
    if (itemOrder.isPresent()){
        delete(itemOrder.get());
    }
    }
}
