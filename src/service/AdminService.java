package service;


import domain.Admin;

/**
 * 管理员的业务接口
 */
public interface AdminService {
    /**
     * 管理员登录
     */
    Admin login(Admin admin);

    void updatePassword(String adminid, String newpassword);

    Admin findAdminById(Admin admin);
}
