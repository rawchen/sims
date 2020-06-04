package dao.impl;

import dao.TeacherDao;
import domain.Course;
import domain.Student;
import domain.Teacher;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.util.List;

public class TeacherDaoImpl implements TeacherDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public Teacher findTeacheridAndPassword(String id, String password) {
        try {
            String sql = "select * from teacher where t_id = ? and t_password = ?";
            Teacher teacher = template.queryForObject(sql,new BeanPropertyRowMapper<Teacher>(Teacher.class),id,password);
            return teacher;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Teacher> findAll() {
        try {
            String sql = "select * from teacher";
            List<Teacher> teachers = template.query(sql, new BeanPropertyRowMapper<Teacher>(Teacher.class));
            return teachers;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Course> findMySelfOptionalCourse(String t_id) {
        try {
            String sql = "select * from course where t_id = ?";
            List<Course> courses = template.query(sql, new BeanPropertyRowMapper<Course>(Course.class),t_id);
            return courses;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Course findOptionalCourseByCourseId(String cid) {
        try {
            String sql = "select * from course where c_id = ?";
            Course c = template.queryForObject(sql,new BeanPropertyRowMapper<Course>(Course.class),cid);
            return c;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void updateCourseInfo(Course updateCourse) {
        try {
            String sql = "update course set c_name =?,c_info=? where c_id=?";
            template.update(sql,updateCourse.getC_name(),updateCourse.getC_info(),updateCourse.getC_id());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCourseById(String cid) {
        try {
            String sql = "delete from course where c_id=?";
            template.update(sql,cid);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updatePassword(String teacherid, String newpassword) {
        try {
            String sql = "update teacher set t_password=? where t_id=?";
            template.update(sql,newpassword,teacherid);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Teacher findTeacherById(String t_id) {
        try {
            String sql = "select * from teacher where t_id = ?";
            Teacher teacher = template.queryForObject(sql,new BeanPropertyRowMapper<Teacher>(Teacher.class),t_id);
            return teacher;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void addTeacherAllInfo(Teacher t) {
        try {
            String sql = "insert into teacher(t_id,t_name,t_sex,t_education,t_title) values(?,?,?,?,?)";
            template.update(sql,t.getT_id(),t.getT_name(),t.getT_sex(),t.getT_education(),t.getT_title());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteTeacherById(String teacherid) {
        try {
            String sql = "delete from teacher where t_id=?";
            template.update(sql,teacherid);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateInfo(Teacher t) {
        try {
            String sql = "update teacher set t_name =?,t_sex=?,t_education=?,t_title=? where t_id=?";
            template.update(sql,t.getT_name(),t.getT_sex(),t.getT_education(),t.getT_title(),t.getT_id());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
