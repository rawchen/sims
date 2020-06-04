package web.servlet.student;

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
import java.util.Date;

@WebServlet("/studentPasswordUpdateServlet")
public class StudentPasswordUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        Student student= (Student)session.getAttribute("student");

        String studentid = student.getS_id();
        String newpassword = request.getParameter("student-newpassword");
        String ennewpassword = request.getParameter("student-ennewpassword");
        String regex = "^[\\w]{3,12}$";
        boolean flag = newpassword.matches(regex);
        if (!flag) {
            request.setAttribute("update_msg", "密码格式错误，重新提交！"+String.format("%tT",new Date()));
            request.getRequestDispatcher("/WEB-INF/student/studentUpdatePassword.jsp").forward(request, response);
        } else if (!newpassword.equals(ennewpassword)) {
            request.setAttribute("update_msg", "密码确认错误，请重新提交！" + String.format("%tT", new Date()));
            request.getRequestDispatcher("/WEB-INF/student/studentUpdatePassword.jsp").forward(request, response);
        } else {

            StudentService service= new StudentServiceImpl();
            service.updatePassword(studentid,newpassword);

            Student newStudent = service.findStudentById(student);
            student = newStudent;
            session.setAttribute("student",student);

            request.setAttribute("update_msg", "修改成功！" + String.format("%tT", new Date()));
            request.getRequestDispatcher("/WEB-INF/student/studentUpdatePassword.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
