package web.servlet.student;

import domain.Admin;
import domain.SelectCourse;
import domain.Student;
import domain.Teacher;
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

@WebServlet("/studentSelectCourseListServlet")
public class StudentSelectCourseListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        Student student= (Student)session.getAttribute("student");
        Admin admin =(Admin)session.getAttribute("admin");

        //调用StudentService完成查询
        StudentService studentService = new StudentServiceImpl();
        if (student != null && admin == null) {
            List<SelectCourse> selectcourses = studentService.findAllSelectCourse(student.getS_id());
            //将list存入request域
            request.setAttribute("selectcourses",selectcourses);
            //转发到list.jsp
            request.getRequestDispatcher("/WEB-INF/student/studentSelectCourseList.jsp").forward(request,response);
        } else if (admin != null && student == null) {
            List<SelectCourse> selectcourses = studentService.findSelectCourseAllStudent();
            request.setAttribute("selectcourses", selectcourses);
            request.getRequestDispatcher("/WEB-INF/admin/allStudentSelectCourseList.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
