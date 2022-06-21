package web.servlet.file;

import domain.Admin;
import domain.Student;
import domain.Teacher;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

@WebServlet("/downloadServlet")
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filename = request.getParameter("filename");
        if (filename.equalsIgnoreCase("../") || filename.equalsIgnoreCase("/")) {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
        response.addHeader("content-Type", "application/octet-stream");

        String agent = request.getHeader("User-Agent");

        if (agent.toLowerCase().indexOf("chrome") > 0) {
            response.addHeader("content-Disposition", "attachment;filename=" + new String(filename.getBytes("UTF-8"), "ISO8859-1"));
        } else {
            response.addHeader("content-Disposition", "attachment;filename=" + URLEncoder.encode(filename, "UTF-8"));
        }
        InputStream in = getServletContext().getResourceAsStream("/upload/" + filename);
        ServletOutputStream out = response.getOutputStream();
        byte[] bs = new byte[1024];
        int len = -1;
        while ((len = in.read(bs)) != -1) {
            out.write(bs, 0, len);
        }
        out.close();
        in.close();

        HttpSession session = request.getSession();
        Student student= (Student)session.getAttribute("student");
        Admin admin= (Admin)session.getAttribute("admin");
        Teacher teacher= (Teacher)session.getAttribute("teacher");
        if (student != null && admin == null && teacher == null) {
            request.getRequestDispatcher("/WEB-INF/student/sFindFileList.jsp").forward(request, response);
        } else if (admin != null && student == null && teacher == null) {
            request.getRequestDispatcher("/WEB-INF/admin/aFindFileList.jsp").forward(request, response);
        } else if (teacher != null && admin == null && student == null) {
            request.getRequestDispatcher("/WEB-INF/teacher/tFindFileList.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
