package dao.impl;

import dao.CDCDao;
import domain.CDC;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.util.List;

public class CDCDaoImpl implements CDCDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<CDC> findAllCollege() {
        try {
            String sql = "select distinct college from college_department_class";
            List<CDC> cdcs = template.query(sql, new BeanPropertyRowMapper<CDC>(CDC.class));
            return cdcs;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return  null;
        }
    }

    @Override
    public List<CDC> findAllDepartment() {
        try {
            String sql = "select distinct department from college_department_class";
            List<CDC> cdcs = template.query(sql, new BeanPropertyRowMapper<CDC>(CDC.class));
            return cdcs;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<CDC> findAllClass() {
        try {
            String sql = "select distinct cclass from college_department_class";
            List<CDC> cdcs = template.query(sql, new BeanPropertyRowMapper<CDC>(CDC.class));
            return cdcs;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<CDC> findAll() {
        try {
            String sql = "select * from college_department_class";
            List<CDC> cdcs = template.query(sql, new BeanPropertyRowMapper<CDC>(CDC.class));
            return cdcs;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
