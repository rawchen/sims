package service.impl;

import dao.TeacherDao;
import domain.Course;
import domain.Teacher;
import dao.impl.TeacherDaoImpl;
import service.TeacherService;

import java.util.List;

public class TeacherServiceImpl implements TeacherService {
    private TeacherDao dao = new TeacherDaoImpl();

    @Override
    public Teacher login(Teacher teacher) {
        return dao.findTeacheridAndPassword(teacher.getT_id(),teacher.getT_password());
    }

    @Override
    public List<Teacher> findAll() {
        return dao.findAll();
    }

    @Override
    public List<Course> findMySelfOptionalCourse(String T_id) {
        return dao.findMySelfOptionalCourse(T_id);
    }

    @Override
    public Course findOptionalCourseByCourseId(String cid) {
        return dao.findOptionalCourseByCourseId(cid);
    }

    @Override
    public void updateCourseInfo(Course updateCourse) {
        dao.updateCourseInfo(updateCourse);
    }

    @Override
    public void deleteCourseById(String cid) {
        dao.deleteCourseById(cid);
    }

    @Override
    public void updatePassword(String teacherid, String newpassword) {
        dao.updatePassword(teacherid,newpassword);
    }

    @Override
    public Teacher findTeacherById(Teacher teacher) {
        return dao.findTeacherById(teacher.getT_id());
    }

    @Override
    public void addTeacherAllInfo(Teacher updateTeacher) {
        dao.addTeacherAllInfo(updateTeacher);
    }

    @Override
    public void deleteTeacherById(String teacherid) {
        dao.deleteTeacherById(teacherid);
    }

    @Override
    public void updateInfo(Teacher updateTeacher) {
        dao.updateInfo(updateTeacher);
    }
}
