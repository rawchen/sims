package web.servlet.admin;

import domain.Admin;
import domain.Student;
import service.AdminService;
import service.StudentService;
import service.impl.AdminServiceImpl;
import service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@WebServlet("/adminPasswordUpdateServlet")
public class AdminPasswordUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        Admin admin= (Admin) session.getAttribute("admin");

        String adminid = admin.getA_id();
        String newpassword = request.getParameter("admin-newpassword");
        String ennewpassword = request.getParameter("admin-ennewpassword");
        String regex = "^[\\w]{3,12}$";
        boolean flag = newpassword.matches(regex);
        if (!flag) {
            request.setAttribute("update_msg", "密码格式错误，重新提交！"+String.format("%tT",new Date()));
            request.getRequestDispatcher("/WEB-INF/admin/adminUpdatePassword.jsp").forward(request, response);
        } else if (!newpassword.equals(ennewpassword)) {
            request.setAttribute("update_msg", "密码确认错误，请重新提交！" + String.format("%tT", new Date()));
            request.getRequestDispatcher("/WEB-INF/admin/adminUpdatePassword.jsp").forward(request, response);
        } else {

            AdminService service= new AdminServiceImpl();
            service.updatePassword(adminid,newpassword);

            Admin newAdmin = service.findAdminById(admin);
            admin = newAdmin;
            session.setAttribute("admin",admin);

            request.setAttribute("update_msg", "修改成功！" + String.format("%tT", new Date()));
            request.getRequestDispatcher("/WEB-INF/admin/adminUpdatePassword.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
