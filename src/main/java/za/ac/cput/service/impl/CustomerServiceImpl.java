/* Customer.java
  Interface service for  Customer
   Author: Sinovuyo Mlanjeni (219220387)
    Date: 05 August 2022
  */
package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.entity.Bill;
import za.ac.cput.entity.Customer;
import za.ac.cput.repository.IBillRepository;
import za.ac.cput.repository.ICustomerRepository;
import za.ac.cput.service.ICustomerService;

import java.util.List;
import java.util.Optional;

public class CustomerServiceImpl implements ICustomerService {

    private final ICustomerRepository repository;

    @Autowired
    public CustomerServiceImpl(ICustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Customer save(Customer customer) {

        return this.repository.save(customer);
    }

    @Override
    public Optional<Customer> findById(String id) {

        return this.repository.findById(id);
    }

    @Override
    public void delete(Customer customer) {
        this.repository.delete(customer);

    }

    @Override
    public List<Customer> findAll() {

        return this.repository.findAll();
    }
    @Override
    public void deleteById(String id) {
        Optional<Customer> customer = findById(id);
        if (customer.isPresent()) {
            delete(customer.get());

        }
    }
}
