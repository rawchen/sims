package service;

import domain.Course;
import domain.Teacher;

import java.util.List;

/**
 * 教师管理的业务接口
 */
public interface TeacherService {
    /**
     * 教师登录
     */
    Teacher login(Teacher teacher);

    List<Teacher> findAll();

    List<Course> findMySelfOptionalCourse(String T_id);

    Course findOptionalCourseByCourseId(String cid);

    void updateCourseInfo(Course updateCourse);

    void deleteCourseById(String cid);

    void updatePassword(String teacherid, String newpassword);

    Teacher findTeacherById(Teacher teacher);

    void addTeacherAllInfo(Teacher updateTeacher);

    void deleteTeacherById(String teacherid);

    void updateInfo(Teacher updateTeacher);
}