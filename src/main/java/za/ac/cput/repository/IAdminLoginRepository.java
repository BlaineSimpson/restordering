package za.ac.cput.repository;

import za.ac.cput.entity.AdminLogin;

import java.util.Set;

public interface IAdminLoginRepository extends IRepository<AdminLogin, Integer> {

    Set<AdminLogin> getAll();
}
