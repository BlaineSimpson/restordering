package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.entity.UserLogin;
import za.ac.cput.factory.UserLoginFactory;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserLoginServiceImplTest {

    @Autowired
    private UserLoginServiceImpl service;
    private final UserLogin user = UserLoginFactory.createUser("1", "username", "password");
    private final UserLogin user2 = UserLoginFactory.createUser("2", "username2", "password2");

    @Test
    @Order(1)
    void save() {
        UserLogin create = this.service.save(user);
        UserLogin create2 = this.service.save(user2);
        assertNotNull(create);
        assertNotNull(create2);
        System.out.println(create);
    }

    @Test
    @Order(2)
    void findById() {
        Optional<UserLogin> read = this.service.findById(this.user.getUserLoginId());
        assertAll(
                () -> assertTrue(read.isPresent()),
                () ->assertEquals(this.user, read.get())
        );
        System.out.println(read);
    }

    @Test
    @Order(3)
    void findAll() {
        List<UserLogin> list = this.service.findAll();
        System.out.println(list); //display both users
    }

    @Test
    @Order(4)
    void delete() {
        service.delete(user); //delete user 1
        List<UserLogin> list = this.service.findAll();
        System.out.println(list); //display remaining users
    }
}