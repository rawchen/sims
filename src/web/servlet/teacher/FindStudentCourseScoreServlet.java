package web.servlet.teacher;

import domain.SelectCourse;
import service.SelectCourseService;
import service.impl.SelectCourseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/findStudentCourseScoreServlet")
public class FindStudentCourseScoreServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String cid = request.getParameter("cid");
        System.out.println(cid);

        SelectCourseService service = new SelectCourseServiceImpl();
        List<SelectCourse> scs =  service.findStudentSelectedCourseByCourseId(cid);
        for (int i = 0; i < scs.size(); i++) {
            System.out.println(scs.get(i));
        }

        request.setAttribute("scs",scs);
        request.getRequestDispatcher("/WEB-INF/teacher/findSelectCourseListByCourseId.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
