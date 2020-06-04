package web.servlet.teacher;

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
import java.util.Date;

@WebServlet("/teacherPasswordUpdateServlet")
public class TeacherPasswordUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        Teacher teacher = (Teacher)session.getAttribute("teacher");

        String teacherid = teacher.getT_id();
        String newpassword = request.getParameter("teacher-newpassword");
        String ennewpassword = request.getParameter("teacher-ennewpassword");
        String regex = "^[\\w]{3,12}$";
        boolean flag = newpassword.matches(regex);
        if (!flag) {
            request.setAttribute("update_msg", "密码格式错误，重新提交！"+String.format("%tT",new Date()));
            request.getRequestDispatcher("/WEB-INF/teacher/teacherUpdatePassword.jsp").forward(request, response);
        } else if (!newpassword.equals(ennewpassword)) {
            request.setAttribute("update_msg", "密码确认错误，请重新提交！" + String.format("%tT", new Date()));
            request.getRequestDispatcher("/WEB-INF/teacher/teacherUpdatePassword.jsp").forward(request, response);
        } else {

            TeacherService service= new TeacherServiceImpl();
            service.updatePassword(teacherid,newpassword);

            Teacher newTeacher = service.findTeacherById(teacher);
            teacher = newTeacher;
            session.setAttribute("teacher",teacher);

            request.setAttribute("update_msg", "修改成功！" + String.format("%tT", new Date()));
            request.getRequestDispatcher("/WEB-INF/teacher/teacherUpdatePassword.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
