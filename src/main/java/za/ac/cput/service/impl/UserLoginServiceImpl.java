/* UserLoginServiceImpl.java
 Implementation for UserLogin service
 Author: Ali Mohamed (219113505)
 Date: 26 July 2022
*/
package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.UserLogin;
import za.ac.cput.repository.IUserLoginRepository;
import za.ac.cput.service.IUserLoginService;

import java.util.List;
import java.util.Optional;

@Service
public class UserLoginServiceImpl implements IUserLoginService {

    private final IUserLoginRepository repository;

    @Autowired
    public UserLoginServiceImpl(IUserLoginRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserLogin save(UserLogin userLogin) {
        return this.repository.save(userLogin);
    }

    @Override
    public Optional<UserLogin> findById(String id) {
        return this.repository.findById(id);
    }

    @Override
    public void delete(UserLogin userLogin) {
        this.repository.delete(userLogin);
    }

    @Override
    public List<UserLogin> findAll() {
        return this.repository.findAll();
    }

    @Override
    public void deleteById(String id) {
        Optional<UserLogin> user = findById(id);
        user.ifPresent(this::delete);
    }
}
