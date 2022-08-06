package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.entity.Menu;

import java.util.Set;
/* IMenuRepository.java
 Entity for the Menu
 Author: Blaine Simpson (218020171)


 */
public interface IMenuRepository extends JpaRepository<Menu, String> {

    //create,update,read,delete

}
