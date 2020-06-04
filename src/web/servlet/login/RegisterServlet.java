package web.servlet.login;

import domain.Student;
import service.StudentService;
import service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String studentid = request.getParameter("studentid");
        String password = request.getParameter("password");
        String repassword = request.getParameter("repassword");
        String vcode = request.getParameter("verifycode");

        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");//确保验证一次性
        if (!vcode.equalsIgnoreCase(checkcode_server)){
            request.setAttribute("msg","验证码错误");
            request.setAttribute("studentid",studentid);
            request.setAttribute("password",password);
            request.setAttribute("repassword",repassword);
            request.getRequestDispatcher("register.jsp").forward(request,response);
            return;
        }else {
            Student student = new Student();
            student.setS_id(studentid);
            student.setS_password(password);
            System.out.println(studentid);
            System.out.println(password);
            StudentService service= new StudentServiceImpl();
            service.register(student);
            request.setAttribute("msg","注册成功");
            request.setAttribute("studentid","");
            request.setAttribute("password","");
            request.setAttribute("repassword","");
            request.getRequestDispatcher("register.jsp").forward(request,response);

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
