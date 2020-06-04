package dao;

import domain.Admin;

public interface AdminDao {
    Admin findAdminidAndPassword(String id, String password);

    void updatePassword(String adminid, String newpassword);

    Admin findAdminById(String a_id);
}
