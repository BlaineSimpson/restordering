/* AdminLoginServiceImplTest.java
 Testing the AdminLogin service
 Author: Ali Mohamed (219113505)
 Date: 26 July 2022
*/
package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.entity.AdminLogin;
import za.ac.cput.factory.AdminLoginFactory;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AdminLoginServiceImplTest {

    @Autowired
    private AdminLoginServiceImpl service;
    private final AdminLogin admin = AdminLoginFactory.createAdmin("1", "username", "password");
    private final AdminLogin admin2 = AdminLoginFactory.createAdmin("2", "username2", "password2");

    @Test
    @Order(1)
    void save() {
        AdminLogin create = this.service.save(admin);
        AdminLogin create2 = this.service.save(admin2);
        assertNotNull(create);
        assertNotNull(create2);
        System.out.println(create);
    }

    @Test
    @Order(2)
    void findById() {
        Optional<AdminLogin> read = this.service.findById(this.admin.getAdminLoginId());
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertEquals(this.admin, read.get())
        );
        System.out.println(read);
    }

    @Test
    @Order(3)
    void findAll() {
        List<AdminLogin> list = this.service.findAll();
        System.out.println(list); //display both admins
    }

    @Test
    @Order(4)
    void delete() {
        service.delete(admin); //delete admin 1
        List<AdminLogin> list = this.service.findAll();
        System.out.println(list); //display remaining admins
    }
}