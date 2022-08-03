/* IAdminLoginRepository.java
 Repository interface for admin
 Author: Ali Mohamed (219113505)
 Date: 08 April 2022.
*/

package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.AdminLogin;

import java.util.Set;

@Repository
public interface IAdminLoginRepository extends JpaRepository<AdminLogin, String> {

}
