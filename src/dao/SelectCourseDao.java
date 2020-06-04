package dao;

import domain.SelectCourse;

import java.util.List;

public interface SelectCourseDao {
    List<SelectCourse> findStudentSelectedCourseByCourseId(String cid);

    SelectCourse findScoreByCourseIdAndStudentId(String cid, String sid);

    void upDateScoreByCidAndSid(String cid, String sid, String sScore);
}
