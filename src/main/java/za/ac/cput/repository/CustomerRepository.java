package za.ac.cput.repository;
/* Customer.java
 Entity for the Customer
 Author: Sinovuyo Mlanjeni (219220387)
 Date: 04 April 2022
*/

import za.ac.cput.entity.Customer;
import java.util.HashSet;
import java.util.Set;


public class CustomerRepository implements ICustomerRepository{
    private static CustomerRepository repository = null;
    private Set<Customer> customerDB = null;

    private CustomerRepository(){customerDB = new HashSet<Customer>();}

    public static CustomerRepository getRepository(){
        if(repository==null){
            repository =new CustomerRepository();
        }
        return repository;
    }
    @Override
    public Customer create (Customer customer){
        boolean success = customerDB.add(customer);

        if (!success)
            return null;
        return customer;
    }

    @Override
    public Customer read(String cusId){
        Customer customer = customerDB.stream()
                .filter(i-> i.getCusId().equals(cusId))
                .findAny()
                .orElse(null);

        return customer;
    }

    @Override
    public Customer update(Customer customer){
        Customer oldCustomer=read(customer.getCusId());
        if(oldCustomer !=null){
            customerDB.remove(oldCustomer);
            customerDB.add(customer);
            return customer;
        }
        return null;
    }

    @Override
    public boolean delete(String cusId) {
        Customer customerToDelete=read(cusId);
        if(customerToDelete == null)
            return false;

        customerDB.remove(customerToDelete);

        return true;
    }
    @Override
    public Set<Customer> getAll(){
        return customerDB;
    }



}
