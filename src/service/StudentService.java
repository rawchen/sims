package service;

import domain.Course;
import domain.PageBean;
import domain.SelectCourse;
import domain.Student;
import java.util.List;
import java.util.Map;

/**
 * 学生管理的业务接口
 */
public interface StudentService {
    /**
     * 分页条件查询
     * @param currentPage
     * @param rows
     * @param condition
     * @return
     */
    PageBean<Student> findStudentByPage(String currentPage, String rows, Map<String, String[]> condition);

    /**
     * 查询所有学生信息
     */
    List<Student> findAll();

    Student login(Student student);

    Student findStudentById(Student student);

    void register(Student student);

    void updateInfo(Student student);

    void updatePassword(String studentid, String newpassword);

    List<SelectCourse> findAllSelectCourse(String studentid);

    List<Course> findAllOptionalCourse();

    void addSelectCourse(String studentid, String courseid);

    void deleteStudentById(String studentid);

    void deleteSelectStudent(String[] sids);

    void addStudentAllInfo(Student updateStudent);

    List<SelectCourse> findSelectCourseAllStudent();
}
