package web.servlet.complaints;

import domain.Complaint;
import service.ComplaintService;
import service.impl.ComplaintServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/complaintListServlet")
public class ComplaintListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        ComplaintService service = new ComplaintServiceImpl();
        List<Complaint> complaints = service.findAll();
        request.setAttribute("complaints",complaints);
        request.getRequestDispatcher("/WEB-INF/complaint/complaintsList.jsp").forward(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
