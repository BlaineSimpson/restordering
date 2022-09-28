/*

Service for Inventory
Author: Shuaib Allie (217148867)
 */

package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Inventory;
import za.ac.cput.entity.Item;
import za.ac.cput.repository.IInventoryRepository;
import za.ac.cput.service.IInventoryService;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryServiceImpl implements IInventoryService {

    private final IInventoryRepository repository;


    @Autowired
    public InventoryServiceImpl(IInventoryRepository repository) {
        this.repository = repository;

    }

    @Override
    public Inventory save(Inventory inventory) {
        return this.repository.save(inventory);
    }

    @Override
    public Optional<Item> findById(String id) {
        return this.repository.findById(id);
    }

    @Override
    public void delete(Inventory inventory) {
        this.repository.delete(inventory);

    }

    @Override
    public List<Item> findAll() {
        return this.repository.findAll();
    }

    @Override
    public void deleteById(String id) {
        Optional<Inventory> inventory = findById(id);
        if (inventory.isPresent()) {
            delete(inventory.get());

        }
    }
}
