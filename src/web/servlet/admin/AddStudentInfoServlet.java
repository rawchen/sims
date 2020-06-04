package web.servlet.admin;

import domain.Student;
import service.StudentService;
import service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/addStudentInfoServlet")
public class AddStudentInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        StudentService service= new StudentServiceImpl();
        //先进行判断是否已存在该学生
        String sid = request.getParameter("student-id");
        Student s = new Student();
        s.setS_id(sid);
        Student newStudent = service.findStudentById(s);
        if (newStudent != null) {
            request.setAttribute("update_msg","已存在该学生，请重新添加！"+String.format("%tT",new Date()));
            request.getRequestDispatcher("addStudentServlet").forward(request, response);
        }else {
            String name = request.getParameter("student-name");
            String sex = request.getParameter("student-sex");
            String age = request.getParameter("student-age");
            String phone = request.getParameter("student-phone");
            String email = request.getParameter("student-email");
            String address = request.getParameter("student-address");
            String college = request.getParameter("selectCollege");
            String department = request.getParameter("selectDepartment");
            String cclass = request.getParameter("selectClass");
            if ("".equals(college)) {
                college = "待分配";
            }
            if ("".equals(department)) {
                department = "待分配";
            }
            if ("".equals(cclass)) {
                cclass = "待分配";
            }

            Student updateStudent = new Student();

            updateStudent.setS_id(sid);
            updateStudent.setS_name(name);
            updateStudent.setS_sex(sex);
            updateStudent.setS_age(age);
            updateStudent.setS_phone(phone);
            updateStudent.setS_email(email);
            updateStudent.setS_address(address);
            updateStudent.setS_college(college);
            updateStudent.setS_department(department);
            updateStudent.setS_class(cclass);

            service.addStudentAllInfo(updateStudent);
            request.setAttribute("update_msg","添加成功！"+String.format("%tT",new Date()));
            request.getRequestDispatcher("addStudentServlet").forward(request, response);

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
