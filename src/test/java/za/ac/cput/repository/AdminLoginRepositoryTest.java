/* AdminLoginRepositoryTest.java
 Repository test for admin
 Author: Ali Mohamed (219113505)
 Date: 08 April 2022.
*/
package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.AdminLogin;
import za.ac.cput.entity.UserLogin;
import za.ac.cput.factory.AdminLoginFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class AdminLoginRepositoryTest {
    private static AdminLoginRepository adminLoginRepository = AdminLoginRepository.getAdminLoginRepository();

    private static AdminLogin adminLogin = AdminLoginFactory.createAdmin(1, "admin", "root");
    private static AdminLogin adminLogin2 = AdminLoginFactory.createAdmin(2, "admin2", "root2");

    @Test
    void a_create() {
        AdminLogin create = adminLoginRepository.create(adminLogin);
        assertNotNull(create);
        System.out.println("Created: " + create);
    }
    @Test
    void b_create2() {
        AdminLogin create = adminLoginRepository.create(adminLogin2);
        assertNotNull(create);
        System.out.println("Created: " + create);
    }

    @Test
    void c_read() {
        AdminLogin read = adminLoginRepository.read(adminLogin.getAdminLoginId());
        AdminLogin read2 = adminLoginRepository.read(adminLogin2.getAdminLoginId());

        assertNotNull(read);
        assertNotNull(read2);

        System.out.println(read);
        System.out.println(read2);
    }

    @Test
    void d_update() {
        AdminLogin updated =  new AdminLogin.Builder().copy(adminLogin2)
                .setAdminLoginUserName("new admin")
                .setAdminLoginPassword("newPassword")
                .build();
        assertNotNull(adminLoginRepository.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void e_delete() {
        boolean success = adminLoginRepository.delete(adminLogin.getAdminLoginId());
        assertTrue(success);
        System.out.println(adminLoginRepository.read(adminLogin.getAdminLoginId()));
    }

    @Test
    void f_getAll() {
        System.out.println("Show all: ");
        System.out.println(adminLoginRepository.getAll());
    }

    @Test
    void g_equalTest(){
        AdminLogin expected = adminLoginRepository.read(2);
        AdminLogin result = adminLoginRepository.read(adminLogin2.getAdminLoginId());
        assertEquals(expected, result);
    }
}