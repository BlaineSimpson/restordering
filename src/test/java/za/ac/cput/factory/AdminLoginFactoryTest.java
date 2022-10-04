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
        AdminLogin admin = AdminLoginFactory.createAdmin("", "Admin", "root1");
        assertNull(admin, "ID cannot be empty");
    }
    @Test
    public void nullUsername(){
        AdminLogin admin = AdminLoginFactory.createAdmin("1", "", "root1");
        assertNull(admin, "Username cannot be empty");
    }
    @Test
    public void nullPassword(){
        AdminLogin admin = AdminLoginFactory.createAdmin("1", "Admin", "");
        assertNull(admin, "password cannot be empty");
    }

}