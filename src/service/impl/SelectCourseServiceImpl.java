package service.impl;

import dao.SelectCourseDao;
import dao.impl.SelectCourseDaoImpl;
import domain.SelectCourse;
import service.SelectCourseService;

import java.util.List;

public class SelectCourseServiceImpl implements SelectCourseService {
    private SelectCourseDao dao = new SelectCourseDaoImpl();

    @Override
    public List<SelectCourse> findStudentSelectedCourseByCourseId(String cid) {
        return dao.findStudentSelectedCourseByCourseId(cid);
    }

    @Override
    public SelectCourse findScoreByCourseIdAndStudentId(String cid, String sid) {
        return dao.findScoreByCourseIdAndStudentId(cid,sid);
    }

    @Override
    public void upDateScoreByCidAndSid(String cid, String sid, String sScore) {
        dao.upDateScoreByCidAndSid(cid,sid,sScore);
    }
}
