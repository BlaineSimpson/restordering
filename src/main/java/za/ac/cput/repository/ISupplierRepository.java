/*

Author Shuaib Allie (217148867)

 */
package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.Supplier;

import java.util.Set;


@Repository
public interface ISupplierRepository extends JpaRepository<Supplier,String> {
    Supplier create(Supplier supplier);

    Supplier read(String inv);

    Supplier update(Supplier supplier);

    boolean delete(String inv);

    Set<Supplier> getAll();
//create, read, update, delete



}