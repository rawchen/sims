package dao.impl;

import dao.AdminDao;
import domain.Admin;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

public class AdminDaoImpl implements AdminDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public Admin findAdminidAndPassword(String id, String password) {
        try {
            String sql = "select * from admin where a_id = ? and a_password = ?";
            Admin admin = template.queryForObject(sql,new BeanPropertyRowMapper<Admin>(Admin.class),id,password);
            return admin;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void updatePassword(String adminid, String newpassword) {
        try {
            String sql = "update admin set a_password=? where a_id=?";
            template.update(sql,newpassword,adminid);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Admin findAdminById(String id) {
        try {
            String sql = "select * from admin where a_id = ?";
            Admin admin = template.queryForObject(sql,new BeanPropertyRowMapper<Admin>(Admin.class),id);
            return admin;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
