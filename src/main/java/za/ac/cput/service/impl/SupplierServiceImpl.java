/*

Service for Supplier
Author: Shuaib Allie (217148867)
 */

package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Item;
import za.ac.cput.entity.Supplier;
import za.ac.cput.repository.ISupplierRepository;
import za.ac.cput.service.ISupplierService;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierServiceImpl implements ISupplierService {

    private final ISupplierRepository repository;


    @Autowired
    public SupplierServiceImpl(ISupplierRepository repository) {
        this.repository = repository;

    }

    @Override
    public Supplier save(Supplier supplier) {
        return this.repository.save(supplier);
    }

    @Override
    public Optional<Item> findById(String id) {
        return this.repository.findById(id);
    }

    @Override
    public void delete(Supplier supplier) {
        this.repository.delete(supplier);

    }

    @Override
    public List<Item> findAll() {
        return this.repository.findAll();
    }

    @Override
    public void deleteById(String id) {
        Optional<Supplier> supplier = findById(id);
        if (supplier.isPresent()) {
            delete(supplier.get());

        }
    }
}
