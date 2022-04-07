package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.UserLogin;
import za.ac.cput.factory.UserLoginFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class UserLoginRepositoryTest {
    private static UserLoginRepository userLoginRepository = UserLoginRepository.getUserLoginRepository();

    private static UserLogin userLogin = UserLoginFactory.createUser(1, "User", "root");
    private static UserLogin userLogin2 = UserLoginFactory.createUser(2, "User2", "toor2");

    @Test
    void a_create() {
        UserLogin create = userLoginRepository.create(userLogin);
        assertNotNull(create);
        System.out.println("Created: " + create);
    }
    @Test
    void b_create2() {
        UserLogin create = userLoginRepository.create(userLogin2);
        assertEquals(userLogin2.getUserLoginId(), create.getUserLoginId());
        System.out.println("Created: " + create);
    }

    @Test
    void c_read() {
        UserLogin read = userLoginRepository.read(userLogin.getUserLoginId());
        UserLogin read2 = userLoginRepository.read(userLogin2.getUserLoginId());

        assertNotNull(read);
        assertNotNull(read2);

        System.out.println(read);
        System.out.println(read2);
    }

    @Test
    void d_update() {
        UserLogin updated = new UserLogin.Builder().copy(userLogin2)
                .setUserLoginUsername("new user")
                .setUserLoginPassword("newPassword")
                .build();
        assertNotNull(userLoginRepository.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void e_delete() {
        boolean success = userLoginRepository.delete(userLogin.getUserLoginId());
        assertTrue(success);
        System.out.println(userLoginRepository.read(userLogin.getUserLoginId()));
    }

    @Test
    void f_getAll() {
        System.out.println("Show all: ");
        System.out.println(userLoginRepository.getAll());
    }

    @Test
    void g_equalTest(){
        UserLogin expected = userLoginRepository.read(2);
        UserLogin result = userLoginRepository.read(userLogin2.getUserLoginId());
        assertEquals(expected, result);
    }
}