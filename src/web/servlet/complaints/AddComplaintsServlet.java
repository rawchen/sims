package web.servlet.complaints;

import domain.Complaint;
import service.ComplaintService;
import service.NotifyService;
import service.impl.ComplaintServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/addComplaintsServlet")
public class AddComplaintsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        //获取参数
        Complaint complaint = new Complaint();

        String text = (String) request.getParameter("complaint");

        if (text.contains("script") && text.contains("/script")) {
            text = text.replace("script","");
            text = text.replace("/script","");
        }

        if (!text.equals("")) {
            complaint.setContent(text);
            Date d = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            complaint.setCdate(sdf.format(d));
            ComplaintService service = new ComplaintServiceImpl();
            service.addComplaint(complaint);
        }

        response.sendRedirect("complaintServlet");
//        request.getRequestDispatcher("/complaintListServlet").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
