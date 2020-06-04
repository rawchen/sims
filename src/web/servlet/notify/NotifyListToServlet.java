package web.servlet.notify;

import domain.Admin;
import domain.Notify;
import domain.Student;
import domain.Teacher;
import service.NotifyService;
import service.impl.NotifyServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/notifyListToServlet")
public class NotifyListToServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        NotifyService service = new NotifyServiceImpl();
        List<Notify> notifys = service.findAll();
        request.setAttribute("notifys",notifys);

        HttpSession session = request.getSession();
        Student student= (Student)session.getAttribute("student");
        Teacher teacher= (Teacher)session.getAttribute("teacher");
        if (student != null && teacher == null) {
            request.getRequestDispatcher("/WEB-INF/notify/notifyListToStudent.jsp").forward(request,response);
        } else if (teacher != null && student == null) {
            request.getRequestDispatcher("/WEB-INF/notify/notifyListToTeacher.jsp").forward(request,response);
        } else {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
