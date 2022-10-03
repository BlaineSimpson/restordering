/* Bill.java
   Author: Sinovuyo Mlanjeni (219220387)
    Date: 05 August 2022
  */
package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Bill;
import za.ac.cput.repository.IBillRepository;
import za.ac.cput.service.IBillService;
import java.util.List;
import java.util.Optional;

@Service
public class BillServiceImpl implements IBillService {

    private final IBillRepository repository;

    @Autowired
    public BillServiceImpl(IBillRepository repository) {
        this.repository = repository;
    }
    @Override
    public Bill save(Bill bill) {

        return this.repository.save(bill);
    }

    @Override
    public Optional<Bill> findById(String id) {

        return this.repository.findById(id);
    }

    @Override
    public void delete(Bill bill) {
        this.repository.delete(bill);

    }
    @Override
    public List<Bill> findAll() {

        return this.repository.findAll();
    }
    @Override
    public void deleteById(String id) {
        Optional<Bill> bill = findById(id);
        if (bill.isPresent()) {
            delete(bill.get());

        }
    }

}

