package service.impl;

import dao.AdminDao;
import dao.impl.AdminDaoImpl;
import domain.Admin;
import service.AdminService;

public class AdminServiceImpl implements AdminService {
    private AdminDao dao = new AdminDaoImpl();

    @Override
    public Admin login(Admin admin) {
        return dao.findAdminidAndPassword(admin.getA_id(),admin.getA_password());
    }

    @Override
    public void updatePassword(String adminid, String newpassword) {
        dao.updatePassword(adminid,newpassword);
    }

    @Override
    public Admin findAdminById(Admin admin) {
        return dao.findAdminById(admin.getA_id());
    }
}
