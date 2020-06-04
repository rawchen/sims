package service.impl;

import dao.StudentDao;
import dao.impl.StudentDaoImpl;
import domain.Course;
import domain.PageBean;
import domain.SelectCourse;
import domain.Student;
import service.StudentService;
import java.util.List;
import java.util.Map;

public class StudentServiceImpl implements StudentService {
    private StudentDao dao = new StudentDaoImpl();

    @Override
    public PageBean<Student> findStudentByPage(String _currentPage, String _rows, Map<String, String[]> condition) {

        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);

        //创建新的PageBean对象
        PageBean<Student> pb = new PageBean<Student>();

        //设置参数
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);

        //调用dao查询总记录数
        int totalCount = dao.findTotalCount(condition);
        pb.setTotalCount(totalCount);

        //调用dao查询List集合
        //计算开始记录的索引
        int start = (currentPage - 1) * rows;
        List<Student>list = dao.findByPage(start,rows,condition);
        pb.setList(list);

        //计算总页码
        int totalPage = (totalCount % rows) == 0 ? totalCount/rows : (totalCount/rows) + 1;
        pb.setTotalPage(totalPage);
        return pb;
    }

    @Override
    public List<Student> findAll() {
        return dao.findAll();
    }

    @Override
    public Student login(Student student) {
        return dao.findStudentidAndPassword(student.getS_id(),student.getS_password());
    }

    @Override
    public Student findStudentById(Student student) {
        return dao.findStudentById(student.getS_id());
    }

    @Override
    public void register(Student student) {
        dao.addStudent(student);
    }

    @Override
    public void updateInfo(Student student) {
        dao.updateInfo(student);
    }

    @Override
    public void updatePassword(String studentid, String newpassword) {
        dao.updatePassword(studentid,newpassword);
    }

    @Override
    public List<SelectCourse> findAllSelectCourse(String studentid) {
        return dao.findAllSelectCourse(studentid);
    }

    @Override
    public List<Course> findAllOptionalCourse() {
        return dao.findAllOptionalCourse();
    }

    @Override
    public void addSelectCourse(String studentid, String courseid) {
        dao.addSelectCourse(studentid,courseid);
    }

    @Override
    public void deleteStudentById(String studentid) {
        dao.deleteStudentById(studentid);
    }

    @Override
    public void deleteSelectStudent(String[] sids) {
        if (sids != null && sids.length > 0) {
            for (String sid: sids) {
                dao.deleteStudentById(sid);
            }
        }

    }

    @Override
    public void addStudentAllInfo(Student updateStudent) {
        dao.addStudentAllInfo(updateStudent);
    }

    @Override
    public List<SelectCourse> findSelectCourseAllStudent() {
        return dao.findSelectCourseAllStudent();
    }
}
