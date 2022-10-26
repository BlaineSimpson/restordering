/* AdminLoginFactoryTest.java
 Test the admin factory class
 Author: Ali Mohamed (219113505)
 Date: 04 April 2022.
*/
package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.AdminLogin;

import static org.junit.jupiter.api.Assertions.*;

class AdminLoginFactoryTest {

    @Test
    public void notNullValues(){
        AdminLogin admin = AdminLoginFactory.createAdmin("1", "Admin", "root1");

        assertNotNull(admin);

        System.out.println(admin);

        System.out.println(admin.getAdminLoginId());
        System.out.println(admin.getAdminLoginUsername());
        System.out.println(admin.getAdminLoginPassword());
    }
    @Test
    public void nullId(){
        assertThrows(IllegalArgumentException.class, () -> AdminLoginFactory.createAdmin(null, "Admin", "root1"));
    }
    @Test
    public void nullUsername(){
        assertThrows(IllegalArgumentException.class, () -> AdminLoginFactory.createAdmin("1", null, "root1"));
    }
    @Test
    public void nullPassword(){
        assertThrows(IllegalArgumentException.class, () -> AdminLoginFactory.createAdmin("1", "Admin", null));
    }
    @Test
    public void nullAll(){
        assertThrows(IllegalArgumentException.class, () -> AdminLoginFactory.createAdmin(null, null, null));
    }

}