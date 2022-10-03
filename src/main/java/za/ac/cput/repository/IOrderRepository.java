package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.Orderr;

@Repository
public interface IOrderRepository extends JpaRepository<Orderr,String> {

}
