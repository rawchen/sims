package service.impl;

import dao.CourseDao;
import dao.impl.CourseDaoImpl;
import domain.Course;
import service.CourseService;

public class CourseServiceImpl implements CourseService {
    private CourseDao dao = new CourseDaoImpl();
    @Override
    public void addOptionalCourse(Course course) {
        dao.addOptionalCourse(course);
    }

    @Override
    public Course findSelectCourseByCourseId(String cid) {
        return dao.findSelectCourseByCourseId(cid);
    }

    @Override
    public void deleteServiceById(String cid) {
        dao.deleteServiceById(cid);
    }
}
