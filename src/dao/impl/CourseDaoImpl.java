package dao.impl;

import dao.CourseDao;
import domain.Course;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

public class CourseDaoImpl implements CourseDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public void addOptionalCourse(Course c) {
        try {
            String sql = "insert into course values(?,?,?,?)";
            template.update(sql,c.getC_id(),c.getC_name(),c.getT_id(),c.getC_info());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Course findSelectCourseByCourseId(String cid) {
        try {
            String sql = "select * from course where c_id = ?";
            Course course = template.queryForObject(sql,new BeanPropertyRowMapper<Course>(Course.class),cid);
            return course;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void deleteServiceById(String cid) {
        try {
            String sql = "delete from course where c_id=?";
            template.update(sql,cid);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }
}
