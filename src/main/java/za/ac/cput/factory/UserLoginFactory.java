/* UserLoginFactory.java
 Entity for the creation of User Login
 Author: Ali Mohamed (219113505)
 Date: 03 April 2022.
*/

package za.ac.cput.factory;

import za.ac.cput.entity.UserLogin;
import za.ac.cput.util.LoginHelper;

public class UserLoginFactory {

    public static UserLogin createUser(int userLoginId, String userLoginUsername, String userLoginPassword){
        if (LoginHelper.isNull(userLoginUsername) || LoginHelper.isNull(userLoginPassword))
            return null;
        if (LoginHelper.invalidId(userLoginId))
            return null;

        return new UserLogin.Builder().setUserLoginId(userLoginId)
                .setUserLoginUsername(userLoginUsername)
                .setUserLoginPassword(userLoginPassword)
                .build();
    }
}
