/* IUserLoginRepository.java
 Repository interface for user
 Author: Ali Mohamed (219113505)
 Date: 08 April 2022.
*/

package za.ac.cput.repository;

import za.ac.cput.entity.UserLogin;

import java.util.Set;

public interface IUserLoginRepository extends IRepository<UserLogin, Integer>{
    Set<UserLogin> getAll();
}
