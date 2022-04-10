/* UserLoginRepository.java
 Repository for user
 Author: Ali Mohamed (219113505)
 Date: 08 April 2022.
*/
package za.ac.cput.repository;

import za.ac.cput.entity.UserLogin;

import java.util.HashSet;
import java.util.Set;

public class UserLoginRepository implements IUserLoginRepository{
    private static UserLoginRepository userLoginRepository = null;
    private Set<UserLogin> userLoginDB;

    private UserLoginRepository(){
        userLoginDB = new HashSet<UserLogin>();
    }

    public static UserLoginRepository getUserLoginRepository(){
        if(userLoginRepository == null)
            userLoginRepository = new UserLoginRepository();
        return userLoginRepository;
    }

    @Override
    public UserLogin create(UserLogin userLogin) {
        if (userLoginDB.add(userLogin) != true) //if adding is not successful, return null
            return null;
        return userLogin;
    }

    @Override
    public UserLogin read(Integer userLoginId) {
        for (UserLogin user : userLoginDB)
            if (user.getUserLoginId() == userLoginId)
                return user;
        return null;
    }

    @Override
    public UserLogin update(UserLogin userLogin) {
        UserLogin previousUser = read(userLogin.getUserLoginId());
        if (previousUser != null){
            userLoginDB.remove(previousUser);
            userLoginDB.add(userLogin);
            return userLogin;
        }
        return null;
    }

    @Override
    public boolean delete(Integer userLoginId) {
        UserLogin userLogin = read(userLoginId);
        if (userLogin != null) {
            userLoginDB.remove(userLogin);
            return true;
        }
        return false;
    }

    @Override
    public Set<UserLogin> getAll() {
        return userLoginDB;
    }
}
