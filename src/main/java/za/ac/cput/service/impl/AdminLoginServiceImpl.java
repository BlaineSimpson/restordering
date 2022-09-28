/* AdminLoginServiceImpl.java
 Implementation for AdminLogin service
 Author: Ali Mohamed (219113505)
 Date: 26 July 2022
*/
package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.AdminLogin;
import za.ac.cput.entity.Item;
import za.ac.cput.repository.IAdminLoginRepository;
import za.ac.cput.service.IAdminLoginService;

import java.util.List;
import java.util.Optional;

@Service
public class AdminLoginServiceImpl implements IAdminLoginService {

    private final IAdminLoginRepository repository;

    @Autowired
    public AdminLoginServiceImpl(IAdminLoginRepository repository) {
        this.repository = repository;
    }

    @Override
    public AdminLogin save(AdminLogin adminLogin) {
        return this.repository.save(adminLogin);
    }

    @Override
    public Optional<Item> findById(String id) {
        return this.repository.findById(id);
    }

    @Override
    public void delete(AdminLogin adminLogin) {
        this.repository.delete(adminLogin);
    }

    @Override
    public List<Item> findAll() {
        return this.repository.findAll();
    }

    @Override
    public void deleteById(String id) {
        Optional<AdminLogin> admin = findById(id);
        admin.ifPresent(this::delete);
    }
}
