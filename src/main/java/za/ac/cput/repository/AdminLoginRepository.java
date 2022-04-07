package za.ac.cput.repository;

import za.ac.cput.entity.AdminLogin;

import java.util.HashSet;
import java.util.Set;

public class AdminLoginRepository implements IAdminLoginRepository{
    private static AdminLoginRepository adminLoginRepository = null;
    private Set<AdminLogin> adminLoginDB;

    private AdminLoginRepository(){
        adminLoginDB = new HashSet<AdminLogin>();
    }

    public static AdminLoginRepository getAdminLoginRepository(){
        if (adminLoginRepository == null)
            adminLoginRepository = new AdminLoginRepository();
        return adminLoginRepository;
    }

    @Override
    public AdminLogin create(AdminLogin adminLogin) {
        if (adminLoginDB.add(adminLogin) != true) //if adding is not successful, return null
            return null;
        return adminLogin;
    }

    @Override
    public AdminLogin read(Integer adminLoginId) {
        for (AdminLogin admin: adminLoginDB)
            if (admin.getAdminLoginId() == adminLoginId)
                return admin;
        return null;
    }

    @Override
    public AdminLogin update(AdminLogin adminLogin) {
        AdminLogin previousAdmin = read(adminLogin.getAdminLoginId());
        if (previousAdmin != null){
            adminLoginDB.remove(previousAdmin);
            adminLoginDB.add(adminLogin);
            return adminLogin;
        }
        return null;
    }

    @Override
    public boolean delete(Integer adminLoginId) {
        AdminLogin adminLogin = read(adminLoginId);
        if (adminLogin != null){
            adminLoginDB.remove(adminLogin);
            return true;
        }
        return false;
    }

    @Override
    public Set<AdminLogin> getAll() {
        return adminLoginDB;
    }
}
