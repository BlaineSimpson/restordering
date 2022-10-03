package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Item;

@Repository
public interface IItemRepository extends JpaRepository<Item,String> {

}
