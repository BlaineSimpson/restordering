package za.ac.cput.service;

import za.ac.cput.entity.AdminLogin;

import java.util.List;
import java.util.Optional;

/**
 * The repository has direct access to the database
 * The service has direct access to repository layer and also implements business logic
 *
 */

public interface IService<T,ID>{
    T save(T t);
    Optional<T> findById(ID id);
    // T update(T t);
    void delete(T t);
    List<T> findAll();
    void deleteById(ID id);
}
