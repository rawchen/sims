package dao.impl;

import dao.StudentDao;
import domain.Course;
import domain.SelectCourse;
import domain.Student;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StudentDaoImpl implements StudentDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Student> findAll() {
        //使用JDBC操作数据库
        try {
            String sql = "select * from student";
            List<Student> students = template.query(sql, new BeanPropertyRowMapper<Student>(Student.class));
            return students;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public Student findStudentidAndPassword(String id,String password) {
        try {
            String sql = "select * from student where s_id = ? and s_password = ?";
            Student student = template.queryForObject(sql,new BeanPropertyRowMapper<Student>(Student.class),id,password);
            return student;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Student findStudentById(String id) {
        try {
            String sql = "select * from student where s_id = ?";
            Student student = template.queryForObject(sql,new BeanPropertyRowMapper<Student>(Student.class),id);
            return student;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void addStudent(Student student) {
        try {
            String sql = "insert into student(s_id,s_password) values(?,?)";
            template.update(sql,student.getS_id(),student.getS_password());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateInfo(Student student) {
        try {
            String sql = "update student set s_name =?,s_sex=?,s_age=?,s_phone=?,s_email=?,s_address=?,s_college=?,s_department=?,s_class=? where s_id=?";
            template.update(sql,student.getS_name(),student.getS_sex(),student.getS_age(),student.getS_phone(),student.getS_email(),student.getS_address(),student.getS_college(),student.getS_department(),student.getS_class(),student.getS_id());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updatePassword(String studentid, String newpassword) {
        try {
            String sql = "update student set s_password=? where s_id=?";
            template.update(sql,newpassword,studentid);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<SelectCourse> findAllSelectCourse(String studentid) {
        try {
            String sql = "select student.s_id,student.s_name,course.c_id,course.c_name,course.c_info,teacher.t_id,t_name,select_course.score\n" +
                    "from select_course,student,course,teacher\n" +
                    "where student.s_id=select_course.s_id\n" +
                    "and select_course.c_id=course.c_id\n" +
                    "and course.t_id=teacher.t_id\n" +
                    "and student.s_id=?";
            List<SelectCourse> scs = template.query(sql, new BeanPropertyRowMapper<SelectCourse>(SelectCourse.class),studentid);
            return scs;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Course> findAllOptionalCourse() {
        try {
            String sql = "select course.c_id,course.c_name,course.c_info,teacher.t_id,t_name\n" +
                    "from course,teacher\n" +
                    "where course.t_id=teacher.t_id";
            List<Course> cs = template.query(sql, new BeanPropertyRowMapper<Course>(Course.class));
            return cs;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void addSelectCourse(String studentid, String courseid) {
        try {
            String sql = "insert into select_course(s_id,c_id) values(?,?)";
            template.update(sql,studentid,courseid);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteStudentById(String studentid) {
        try {
            String sql = "delete from student where s_id=?";
            template.update(sql,studentid);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        //定义模板初始化sql
        String sql = "select count(*) from student where 1=1";
        StringBuilder sb = new StringBuilder(sql);
        //遍历map
        Set<String> keySet = condition.keySet();
        //定义参数集合
        List<Object> params = new ArrayList<Object>();
        for (String key : keySet) {
            System.out.println(key);
            //排除分页条件参数
            if ("currentPage".equals(key) || "rows".equals(key)) {
                continue;
            }

            //获取value
            String value = condition.get(key)[0];
            //判断value是否有值
            if (value != null && !"".equals(value)) {
                //有值
                sb.append(" and "+key+" like ? ");
                params.add("%"+value+"%");//?条件的值
            }
        }
        System.out.println(sb.toString());
        System.out.println(params);
        return template.queryForObject(sb.toString(),Integer.class,params.toArray());
    }

    @Override
    public void addStudentAllInfo(Student s) {
        try {
            String sql = "insert into student(s_id,s_college,s_department,s_class,s_name,s_sex,s_age,s_phone,s_email,s_address) values(?,?,?,?,?,?,?,?,?,?)";
            template.update(sql,s.getS_id(),s.getS_college(),s.getS_department(),s.getS_class(),s.getS_name(),s.getS_sex(),s.getS_age(),s.getS_phone(),s.getS_email(),s.getS_address());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<SelectCourse> findSelectCourseAllStudent() {
        try {
            String sql = "select student.s_id,student.s_name,course.c_id,course.c_name,course.c_info,teacher.t_id,t_name,select_course.score\n" +
                    "from select_course,student,course,teacher\n" +
                    "where student.s_id=select_course.s_id\n" +
                    "and select_course.c_id=course.c_id\n" +
                    "and course.t_id=teacher.t_id\n";
            List<SelectCourse> scs = template.query(sql, new BeanPropertyRowMapper<SelectCourse>(SelectCourse.class));
            return scs;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public List<Student> findByPage(int start, int rows, Map<String, String[]> condition) {
        try {
            String sql = "select * from student where 1=1";
            StringBuilder sb = new StringBuilder(sql);
            //遍历map
            Set<String> keySet = condition.keySet();
            //定义参数集合
            List<Object> params = new ArrayList<Object>();
            for (String key : keySet) {
                //排除分页条件参数
                if ("currentPage".equals(key) || "rows".equals(key)) {
                    continue;
                }

                //获取value
                String value = condition.get(key)[0];
                //判断value是否有值
                if (value != null && !"".equals(value)) {
                    //有值
                    sb.append(" and "+key+" like ? ");
                    params.add("%"+value+"%");//?条件的值
                }
            }
            //添加分页查询
            sb.append(" limit ? , ?");
            //添加分页查询参数值
            params.add(start);
            params.add(rows);
            System.out.println(sb.toString());
            System.out.println(params);
            return template.query(sb.toString(),new BeanPropertyRowMapper<Student>(Student.class),params.toArray());
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
