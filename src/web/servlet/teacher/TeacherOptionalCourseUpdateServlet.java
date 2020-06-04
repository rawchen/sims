package web.servlet.teacher;

import domain.Course;
import domain.Teacher;
import service.TeacherService;
import service.impl.TeacherServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@WebServlet("/teacherOptionalCourseUpdateServlet")
public class TeacherOptionalCourseUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String cid =request.getParameter("cid");

        //保存输入内容
        String name = request.getParameter("course-name");
        String info = request.getParameter("course-info");

        Course updateCourse = new Course();

        //判断输入位数是否大于数据库位数
        if (cid.contains("<") || name.contains("<") || info.contains("<")) {
            request.setAttribute("update_msg","格式错误，请重新提交！"+String.format("%tT",new Date()));
            request.getRequestDispatcher("updateTeacherOptionalCourseServlet?cid="+cid).forward(request, response);
        }else {
            //封装学生对象
            updateCourse.setC_id(cid);
            updateCourse.setC_name(name);
            updateCourse.setC_info(info);

            //调用studentUpdata服务
            TeacherService service= new TeacherServiceImpl();
            service.updateCourseInfo(updateCourse);

            //成功则返回并给提示
            request.setAttribute("update_msg", "修改成功！"+String.format("%tT",new Date()));
            request.getRequestDispatcher("updateTeacherOptionalCourseServlet?cid="+cid).forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
