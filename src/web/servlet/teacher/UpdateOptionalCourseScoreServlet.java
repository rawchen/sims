package web.servlet.teacher;

import domain.Course;
import domain.SelectCourse;
import domain.Student;
import domain.Teacher;
import service.CourseService;
import service.SelectCourseService;
import service.StudentService;
import service.impl.CourseServiceImpl;
import service.impl.SelectCourseServiceImpl;
import service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@WebServlet("/updateOptionalCourseScoreServlet")
public class UpdateOptionalCourseScoreServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String cid = request.getParameter("cid");
        String sid = request.getParameter("sid");
        String sScore = request.getParameter("student-score");
        StudentService service = new StudentServiceImpl();
        CourseService service1 = new CourseServiceImpl();
        SelectCourseService service2 = new SelectCourseServiceImpl();

        service2.upDateScoreByCidAndSid(cid,sid,sScore);

        Student student = new Student();
        student.setS_id(sid);

        Student s = service.findStudentById(student);
        Course c = service1.findSelectCourseByCourseId(cid);
        SelectCourse sc = service2.findScoreByCourseIdAndStudentId(cid,sid);

        request.setAttribute("s",s);
        request.setAttribute("c",c);
        request.setAttribute("sc",sc);
        request.setAttribute("update_msg","修改分数成功！"+String.format("%tT",new Date()));
        request.getRequestDispatcher("/WEB-INF/teacher/updateOptionalCourseScore.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
