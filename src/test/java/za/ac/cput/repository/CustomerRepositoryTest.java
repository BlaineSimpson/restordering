package za.ac.cput.repository;
/* Customer.java
 Entity for the Customer
 Author: Sinovuyo Mlanjeni (219220387)
 Date: 04 April 2022
*/


import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Customer;
import za.ac.cput.factory.CustomerFactory;


import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)

class CustomerRepositoryTest {
    private static CustomerRepository repository
            = CustomerRepository.getRepository();
    private static Customer customer=
            CustomerFactory.createCustomer("5685", "Miah", "Henniear","5485@cput.ac.za", "545 lembo, Gumede" );
    private static Customer customer2=
            CustomerFactory.createCustomer("5399"," Richard","Sam", "55478@mycput.ac.za", "21 Avenue, Kensington");

    @Test
    void a_create() {
        Customer created = repository.create(customer);
        assertEquals(customer.getCusId(), created.getCusId());
        System.out.println("Create: " + created);
    }

    @Test
    void b_read(){
        Customer read = repository.read(customer.getCusId());
        assertNotNull(read);
        System.out.println("Read:" +read);
    }

    @Test
    void c_update() {
        Customer updated = new
                Customer.Builder().copy(customer)
                .setCusId("5155")
                .setCusFName("Liam")
                .setCusLName("Zac")
                .setCusEmail("5685@icloud")
                .setCusAddress("12 Mbeki Str, Cape Town")
                .build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void d_delete(){
        boolean success = repository.delete(customer.getCusId());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Test

    void e_getAll(){
        System.out.println("Show all: ");
        System.out.println(repository.getAll());
    }


}