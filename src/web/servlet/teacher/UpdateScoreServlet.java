package web.servlet.teacher;

import domain.Course;
import domain.SelectCourse;
import domain.Student;
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
import java.io.IOException;

@WebServlet("/updateScoreServlet")
public class UpdateScoreServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String cid = request.getParameter("cid");
        String sid = request.getParameter("sid");

        StudentService service = new StudentServiceImpl();
        Student student = new Student();
        student.setS_id(sid);
        Student s = service.findStudentById(student);

        CourseService service1 = new CourseServiceImpl();
        Course c = service1.findSelectCourseByCourseId(cid);

        SelectCourseService service2 = new SelectCourseServiceImpl();
        SelectCourse sc = service2.findScoreByCourseIdAndStudentId(cid,sid);

        request.setAttribute("s",s);
        request.setAttribute("c",c);
        request.setAttribute("sc",sc);
        request.getRequestDispatcher("/WEB-INF/teacher/updateOptionalCourseScore.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
