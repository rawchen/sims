package web.servlet.admin;

import domain.Course;
import service.CourseService;
import service.StudentService;
import service.impl.CourseServiceImpl;
import service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/doDeleteSelectCourseServlet")
public class DoDeleteSelectCourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        String cid = request.getParameter("cid");
        CourseService service = new CourseServiceImpl();
        service.deleteServiceById(cid);
        request.getRequestDispatcher("/studentOptionalCourseServlet").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
