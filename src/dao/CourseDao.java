package dao;

import domain.Course;

public interface CourseDao {
    void addOptionalCourse(Course course);

    Course findSelectCourseByCourseId(String cid);

    void deleteServiceById(String cid);
}
