/*
TableServiceImpl.java
Author Demi Alexis Farquhar (220322104)
Date: 5 August 2022
 */
package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;



import org.springframework.stereotype.Service;
import za.ac.cput.domain.Tablee;
import za.ac.cput.repository.ITableRepository;
import za.ac.cput.service.ITableService;

import java.util.List;
import java.util.Optional;


@Service
public class TableServiceImpl implements ITableService {

    private final ITableRepository repository;

    @Autowired
    public TableServiceImpl(ITableRepository repository) {
        this.repository = repository;
    }

    @Override
    public Tablee save(Tablee table) {
        return this.repository.save(table);
    }

    @Override
    public Optional<Tablee> findById(String id) {
        return this.repository.findById(id);
    }

    @Override
    public void delete(Tablee table) {
    this.repository.delete(table);
    }

    @Override
    public List<Tablee> findAll() {
        return this.repository.findAll();
    }

    @Override
    public void deleteById(String id) {
        Optional<Tablee>table =findById(id);
        table.ifPresent(this::delete);

    }
}
