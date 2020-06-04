package web.servlet.notify;

import domain.Notify;
import service.NotifyService;
import service.impl.NotifyServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/notifyListServlet")
public class NotifyListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        NotifyService service = new NotifyServiceImpl();
        List<Notify> notifys = service.findAll();
        request.setAttribute("notifys",notifys);
        request.getRequestDispatcher("/WEB-INF/notify/notifyList.jsp").forward(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
