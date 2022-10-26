/* UserLoginFactoryTest.java
 Test the user factory class
 Author: Ali Mohamed (219113505)
 Date: 04 April 2022.
*/
package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.UserLogin;

import static org.junit.jupiter.api.Assertions.*;

class UserLoginFactoryTest {


    @Test
    public void notNullValues(){
        UserLogin user = UserLoginFactory.createUser("1", "User", "root1");
        UserLogin user2 = UserLoginFactory.createUser("1", " user2", "root2");
        assertNotNull(user);
        assertNotNull(user2);

        System.out.println(user);
        System.out.println(user2);

        System.out.println(user.getUserLoginId());
        System.out.println(user.getUserLoginUsername());
        System.out.println(user.getUserLoginPassword());
    }

    @Test
    public void nullId(){
        assertThrows(IllegalArgumentException.class, () -> UserLoginFactory.createUser(null, "User", "root1"));
    }

    @Test
    public void nullUsername(){
        assertThrows(IllegalArgumentException.class, () -> UserLoginFactory.createUser("1", null, "root1"));
    }

    @Test
    public void nullPassword(){
        assertThrows(IllegalArgumentException.class, () -> UserLoginFactory.createUser("1", "User", null));
    }
    @Test
    public void nullAll(){
        assertThrows(IllegalArgumentException.class, () -> UserLoginFactory.createUser(null, null, null));
    }


}