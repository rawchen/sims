package web.servlet.teacher;

import domain.Admin;
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

@WebServlet("/teacherListServlet")
public class TeacherListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用TeacherService完成查询
        TeacherService teacherService = new TeacherServiceImpl();
        List<Teacher> teachers = teacherService.findAll();
        //将list存入request域
        request.setAttribute("teachers",teachers);

        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        Student student= (Student)session.getAttribute("student");
        Admin admin= (Admin)session.getAttribute("admin");
        Teacher teacher= (Teacher)session.getAttribute("teacher");
        if (student != null && admin == null && teacher == null) {
            request.getRequestDispatcher("/WEB-INF/student/sFindTeacherList.jsp").forward(request, response);
        } else if (admin != null && student == null && teacher == null) {
            request.getRequestDispatcher("/WEB-INF/admin/aFindTeacherList.jsp").forward(request, response);
        } else if (teacher != null && admin == null && student == null) {
            request.getRequestDispatcher("/WEB-INF/teacher/tFindTeacherList.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
