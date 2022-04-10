/* IAdminLoginRepository.java
 Repository interface for admin
 Author: Ali Mohamed (219113505)
 Date: 08 April 2022.
*/

package za.ac.cput.repository;

import za.ac.cput.entity.AdminLogin;

import java.util.Set;

public interface IAdminLoginRepository extends IRepository<AdminLogin, Integer> {

    Set<AdminLogin> getAll();
}
