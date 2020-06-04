package dao;

import domain.Course;
import domain.SelectCourse;
import domain.Student;

import java.util.List;
import java.util.Map;

/**
 * 学生操作的DAO
 */
public interface StudentDao {
    List<Student> findByPage(int start, int rows, Map<String, String[]> condition);

    List<Student> findAll();

    Student findStudentidAndPassword(String id, String password);

    Student findStudentById(String s_id);

    void addStudent(Student student);

    void updateInfo(Student student);

    void updatePassword(String studentid, String newpassword);

    List<SelectCourse> findAllSelectCourse(String studentid);

    List<Course> findAllOptionalCourse();

    void addSelectCourse(String studentid, String courseid);

    void deleteStudentById(String studentid);

    int findTotalCount(Map<String, String[]> condition);

    void addStudentAllInfo(Student updateStudent);

    List<SelectCourse> findSelectCourseAllStudent();
}
