package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Menu;

/* IMenuRepository.java
 Entity for the Menu
 Author: Blaine Simpson (218020171)


 */
@Repository
public interface IMenuRepository extends JpaRepository<Menu, String> {

    //create,update,read,delete

}
