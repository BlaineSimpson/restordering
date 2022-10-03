/* IUserLoginRepository.java
 Repository interface for user
 Author: Ali Mohamed (219113505)
 Date: 08 April 2022.
*/

package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.UserLogin;

@Repository
public interface IUserLoginRepository extends JpaRepository<UserLogin, String> {

}
