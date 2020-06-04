package web.servlet.login;

import domain.Admin;
import domain.Notify;
import domain.Student;
import domain.Teacher;
import org.apache.commons.beanutils.BeanUtils;
import service.AdminService;
import service.NotifyService;
import service.StudentService;
import service.TeacherService;
import service.impl.AdminServiceImpl;
import service.impl.NotifyServiceImpl;
import service.impl.StudentServiceImpl;
import service.impl.TeacherServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Student loginStudent = null;
        Teacher loginTeacher = null;
        Admin loginAdmin = null;

        //设置编码
        request.setCharacterEncoding("utf-8");

        //获取数据
        String verifycode = request.getParameter("verifycode");
        String loginid = request.getParameter("id");
        String loginpassword = request.getParameter("password");

        //验证码校验
        HttpSession session = request.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");//确保验证一次性
        if (checkcode_server == null || !checkcode_server.equalsIgnoreCase(verifycode)) {
            //验证码不正确
            request.setAttribute("login_msg","验证码错误");
            //跳转页面
            request.setAttribute("loginid",loginid);
            request.setAttribute("loginpassword",loginpassword);
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return;
        }
        //封装对象
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        String roles = request.getParameter("roles");

        //公告加载
        NotifyService notifyService= new NotifyServiceImpl();
        List<Notify> notifys = notifyService.find();
        session.setAttribute("notifys",notifys);

        //判断roles封装对象、保存session、调用不同Service查询
        if ("student".equals(roles)) {

            Student student = new Student();
            student.setS_id(id);
            student.setS_password(password);

            StudentService service= new StudentServiceImpl();
            loginStudent = service.login(student);

            if (loginStudent != null) {
                session.setAttribute("student", loginStudent);
                session.setAttribute("html_title", "学生端");
//                request.getRequestDispatcher("/WEB-INF/student/sIndex.jsp").forward(request,response);
                response.sendRedirect("studentIndexServlet");
            }else {
                //登录失败 提示信息
                request.setAttribute("login_msg", "用户名或密码错误！");
                request.setAttribute("loginid",loginid);
                request.setAttribute("loginpassword",loginpassword);
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        }else if ("teacher".equals(roles)) {

            Teacher teacher = new Teacher();
            teacher.setT_id(id);
            teacher.setT_password(password);

            TeacherService service = new TeacherServiceImpl();
            loginTeacher = service.login(teacher);

            if (loginTeacher != null) {
                session.setAttribute("teacher", loginTeacher);
                session.setAttribute("html_title", "教师端");
//                request.getRequestDispatcher("/WEB-INF/teacher/tIndex.jsp").forward(request, response);
                response.sendRedirect("teacherIndexServlet");
            }else {
                //登录失败 提示信息
                request.setAttribute("login_msg", "用户名或密码错误！");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }

        }else {

            Admin admin = new Admin();
            admin.setA_id(id);
            admin.setA_password(password);

            AdminService service = new AdminServiceImpl();
            loginAdmin = service.login(admin);

            if (loginAdmin != null) {
                session.setAttribute("admin", loginAdmin);
                session.setAttribute("html_title", "管理员");
//                request.getRequestDispatcher("/WEB-INF/admin/aIndex.jsp").forward(request,response);
                response.sendRedirect("adminIndexServlet");
            }else {
                //登录失败 提示信息
                request.setAttribute("login_msg", "用户名或密码错误！");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
