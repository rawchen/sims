package web.servlet.teacher;

import domain.Course;
import domain.Teacher;
import service.CourseService;
import service.impl.CourseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@WebServlet("/addOptionalCourseServlet")
public class AddOptionalCourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        HttpSession session = request.getSession();
        Teacher teacher = (Teacher) session.getAttribute("teacher");

        String cid = request.getParameter("cid");
        String cname = request.getParameter("course-name");
        String cinfo = request.getParameter("course-info");

        CourseService service = new CourseServiceImpl();
        Course course =  service.findSelectCourseByCourseId(cid);
        if (course != null) {
            request.setAttribute("update_msg","课程ID冲突，请重新添加！"+String.format("%tT",new Date()));
            request.getRequestDispatcher("/WEB-INF/teacher/addOptionalCourse.jsp").forward(request,response);
        }else {
            Course newCourse = new Course();
            newCourse.setC_id(cid);
            newCourse.setC_name(cname);
            newCourse.setC_info(cinfo);
            newCourse.setT_id(teacher.getT_id());
            newCourse.setT_name(teacher.getT_name());

            service.addOptionalCourse(newCourse);
            request.setAttribute("update_msg","课程添加成功！"+String.format("%tT",new Date()));
            request.getRequestDispatcher("/WEB-INF/teacher/addOptionalCourse.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
