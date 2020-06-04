package web.servlet.teacher;

import domain.Course;
import service.TeacherService;
import service.impl.TeacherServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/updateTeacherOptionalCourseServlet")
public class UpdateTeacherOptionalCourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
//        HttpSession session = request.getSession();
        String cid = (String)request.getParameter("cid");
        TeacherService service = new TeacherServiceImpl();
        Course c = service.findOptionalCourseByCourseId(cid);
        request.setAttribute("course",c);
        System.out.println(c.getC_id());
        System.out.println(c.getC_name());
        System.out.println(c.getC_info());

        request.getRequestDispatcher("/WEB-INF/teacher/updateTeacherOptionalCourseInfo.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
