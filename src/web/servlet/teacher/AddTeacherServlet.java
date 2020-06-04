package web.servlet.teacher;

import domain.CDC;
import service.CDCService;
import service.impl.CDCServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/addTeacherServlet")
public class AddTeacherServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();

        CDCService service = new CDCServiceImpl();
        List<CDC> collegeList = service.findAllCollege();
        List<CDC> departmentList = service.findAllDepartment();
        List<CDC> classList = service.findAllClass();

        session.setAttribute("collegeLists",collegeList);
        session.setAttribute("departmentLists",departmentList);
        session.setAttribute("classLists",classList);

        request.getRequestDispatcher("/WEB-INF/admin/addTeacher.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
