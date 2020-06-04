package service;

import domain.Course;

public interface CourseService {
    void addOptionalCourse(Course course);

    Course findSelectCourseByCourseId(String cid);

    void deleteServiceById(String cid);
}
