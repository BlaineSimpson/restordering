/*

Author Shuaib Allie (217148867)

 */
package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Inventory;


@Repository
public interface IInventoryRepository extends JpaRepository<Inventory,String> {




}
