/*
Item Service Impl
ItemServiceImpl entity
Author Craig Jarvis (220103216)
Date: 25 September 2022
 */

package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Item;
import za.ac.cput.repository.IItemRepository;
import za.ac.cput.service.IItemService;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements IItemService {

    private final IItemRepository repository;

    @Autowired
    public ItemServiceImpl(IItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public Item save(Item item) {
        return this.repository.save(item);
    }

    @Override
    public Optional<Item> findById(String id) {
        return this.repository.findById(id);
    }

    @Override
    public void delete(Item item) {
        this.repository.delete(item);
    }

    @Override
    public List<Item> findAll() {
        return this.repository.findAll();
    }

    @Override
    public void deleteById(String id) {
        Optional<Item> item = findById(id);
        item.ifPresent(this::delete);
    }
}
