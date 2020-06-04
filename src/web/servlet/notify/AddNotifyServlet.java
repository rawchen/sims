package web.servlet.notify;

import domain.Notify;
import org.apache.commons.beanutils.BeanUtils;
import service.NotifyService;
import service.impl.NotifyServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@WebServlet("/addNotifyServlet")
public class AddNotifyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        //获取参数
        Notify notify = new Notify();
        notify.setNotifyInfo((String) request.getParameter("notifyInfo"));
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        notify.setNotifyDate(sdf.format(d));
        NotifyService service = new NotifyServiceImpl();
        service.addNotify(notify);
//        response.sendRedirect("/notifyListServlet");
        request.getRequestDispatcher("/notifyListServlet").forward(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
