package web.servlet.cdc;

import domain.Admin;
import domain.CDC;
import domain.Student;
import domain.Teacher;
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

@WebServlet("/cdcListServlet")
public class CDCListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //调用StudentService完成查询
        CDCService service = new CDCServiceImpl();
        List<CDC> cdcs = service.findAll();
        //将list存入request域
        request.setAttribute("cdcs",cdcs);

        HttpSession session = request.getSession();
        Student student= (Student)session.getAttribute("student");
        Admin admin= (Admin)session.getAttribute("admin");
        Teacher teacher= (Teacher)session.getAttribute("teacher");

        if (student != null && admin == null && teacher == null) {
            request.getRequestDispatcher("/WEB-INF/student/sCDCList.jsp").forward(request, response);
        } else if (admin != null && student == null && teacher == null) {
            request.getRequestDispatcher("/WEB-INF/admin/aCDCList.jsp").forward(request, response);
        } else if (teacher != null && admin == null && student == null) {
            request.getRequestDispatcher("/WEB-INF/teacher/tCDCList.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
