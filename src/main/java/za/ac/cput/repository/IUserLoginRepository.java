package za.ac.cput.repository;

import za.ac.cput.entity.UserLogin;

import java.util.Set;

public interface IUserLoginRepository extends IRepository<UserLogin, Integer>{
    Set<UserLogin> getAll();
}
