package web.servlet.admin;

import domain.CDC;
import domain.Student;
import service.CDCService;
import service.StudentService;
import service.impl.CDCServiceImpl;
import service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/addStudentServlet")
public class AddStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();

        CDCService service2 = new CDCServiceImpl();
        List<CDC> collegeList = service2.findAllCollege();
        List<CDC> departmentList = service2.findAllDepartment();
        List<CDC> classList = service2.findAllClass();

        session.setAttribute("collegeLists",collegeList);
        session.setAttribute("departmentLists",departmentList);
        session.setAttribute("classLists",classList);

        request.getRequestDispatcher("/WEB-INF/admin/addStudent.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
