package dao;

import domain.Course;
import domain.Teacher;

import java.util.List;

/**
 * 管理员操作的DAO
 */
public interface TeacherDao {
    Teacher findTeacheridAndPassword(String id, String password);

    List<Teacher> findAll();

    List<Course> findMySelfOptionalCourse(String t_id);

    Course findOptionalCourseByCourseId(String cid);

    void updateCourseInfo(Course updateCourse);

    void deleteCourseById(String cid);

    void updatePassword(String teacherid, String newpassword);

    Teacher findTeacherById(String t_id);

    void addTeacherAllInfo(Teacher updateTeacher);

    void deleteTeacherById(String teacherid);

    void updateInfo(Teacher updateTeacher);
}
