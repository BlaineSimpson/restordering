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




}