package web.servlet.login;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Student;
import service.StudentService;
import service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/findStudentServlet")
public class FindStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        String studentId = request.getParameter("studentid");
        Student student = new Student();
        Student findStudent = new Student();
        student.setS_id(studentId);
        StudentService service = new StudentServiceImpl();
        findStudent = service.findStudentById(student);
        Map<String,Object>map = new HashMap<String,Object>();

        try {
            if (studentId.equals(findStudent.getS_id())) {
                map.put("studentExsit", true);
                map.put("msg", "ID已存在");
            } else {
                map.put("studentExsit", false);
                map.put("msg", "用户名可用");
            }
            //map转为json传给客户端
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(response.getWriter(),map);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
