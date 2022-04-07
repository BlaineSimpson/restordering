/* UserLoginFactoryTest.java
 Test the user factory class
 Author: Ali Mohamed (219113505)
 Date: 04 April 2022
*/
package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.UserLogin;

import static org.junit.jupiter.api.Assertions.*;

class UserLoginFactoryTest {


    @Test
    public void notNullValues(){
        UserLogin user = UserLoginFactory.createUser(1, "User", "root1");
        UserLogin user2 = UserLoginFactory.createUser(1, " user2", "root2");
        assertNotNull(user);
        assertNotNull(user2);

        System.out.println(user);
        System.out.println(user2);

        System.out.println(user.getUserLoginId());
        System.out.println(user.getUserLoginUsername());
        System.out.println(user.getUserLoginPassword());
    }

    @Test
    public void idLessThanZero(){
        UserLogin user = UserLoginFactory.createUser(-1, "User", "root1");
        assertNull(user, "ID number can not be less than 0");
    }

    @Test
    public void nullValueUsername(){
        UserLogin user = UserLoginFactory.createUser(1, "", "root1");
        assertNull(user, "Username cannot be empty");
    }

    @Test
    public void nullValuePassword(){
        UserLogin user = UserLoginFactory.createUser(1, "User", "");
        assertNull(user, "Password cannot be empty");
    }
    @Test
    public void nullValuePassword2(){
        UserLogin user = UserLoginFactory.createUser(1, "User", "");
        assertNotNull(user, "This test should fail");
    }


}