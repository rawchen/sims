package web.servlet.student;

import domain.Admin;
import domain.Course;
import domain.SelectCourse;
import domain.Student;
import service.StudentService;
import service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/studentOptionalCourseServlet")
public class StudentOptionalCourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        Student student= (Student)session.getAttribute("student");
        Admin admin =(Admin)session.getAttribute("admin");

        //调用StudentService完成查询
        StudentService studentService = new StudentServiceImpl();
        List<Course> optionalcourses = studentService.findAllOptionalCourse();
        //将list存入request域
        request.setAttribute("optionalcourses",optionalcourses);
        //转发到list.jsp

        if (student != null && admin == null) {
            request.getRequestDispatcher("/WEB-INF/student/studentOptionalCourse.jsp").forward(request,response);
        } else if (admin != null && student == null) {
            request.getRequestDispatcher("/WEB-INF/admin/allStudentOptionalCourse.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
