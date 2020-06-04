package web.servlet.teacher;

import domain.Course;
import domain.Student;
import domain.Teacher;
import service.StudentService;
import service.TeacherService;
import service.impl.StudentServiceImpl;
import service.impl.TeacherServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/teacherOptionalCourseServlet")
public class TeacherOptionalCourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        Teacher t = (Teacher) session.getAttribute("teacher");
        if (t != null) {
            //调用StudentService完成查询
            TeacherService service = new TeacherServiceImpl();
            List<Course> optionalcourses = service.findMySelfOptionalCourse(t.getT_id());
            //将list存入request域
            request.setAttribute("optionalcourses",optionalcourses);
            //转发到list.jsp
            request.getRequestDispatcher("/WEB-INF/teacher/teacherOptionalCourse.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
