package dao.impl;

import dao.SelectCourseDao;
import domain.SelectCourse;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.util.List;

public class SelectCourseDaoImpl implements SelectCourseDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<SelectCourse> findStudentSelectedCourseByCourseId(String cid) {
        try {
            String sql = "select course.c_id,course.c_name,course.c_info,student.s_id,student.s_name,select_course.score\n" +
                    "from select_course,student,course\n" +
                    "where student.s_id=select_course.s_id\n" +
                    "and select_course.c_id=course.c_id\n" +
                    "and select_course.c_id=?";
            List<SelectCourse> scs = template.query(sql, new BeanPropertyRowMapper<SelectCourse>(SelectCourse.class),cid);
            return scs;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public SelectCourse findScoreByCourseIdAndStudentId(String cid, String sid) {
        try {
            String sql = "select * from select_course where c_id=? and s_id=?";
            SelectCourse sc = template.queryForObject(sql, new BeanPropertyRowMapper<SelectCourse>(SelectCourse.class), cid, sid);
            return sc;
        } catch (
        DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void upDateScoreByCidAndSid(String cid, String sid, String sScore) {
        try {
            String sql = "update select_course set score = ? where c_id = ? and s_id = ?";
            template.update(sql,sScore,cid,sid);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }
}
