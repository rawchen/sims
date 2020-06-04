package web.servlet.admin;



import domain.CDC;
import domain.Student;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/updateStudentInfoServlet")
public class UpdateStudentInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
//        HttpSession session = request.getSession();
        String sid = request.getParameter("student-id");
        System.out.println("sid:"+sid);


        //保存输入内容
        String name = request.getParameter("student-name");
        System.out.println("sname:"+name);
        String sex = request.getParameter("student-sex");
        System.out.println("ssex:"+sex);
        String age = request.getParameter("student-age");
        String phone = request.getParameter("student-phone");
        String email = request.getParameter("student-email");
        String address = request.getParameter("student-address");

        String college = request.getParameter("selectCollege");
        String department = request.getParameter("selectDepartment");
        String cclass = request.getParameter("selectClass");

        Student updateStudent = new Student();

        //判断输入位数是否大于数据库位数
        if (name.length() > 4 || phone.length() > 11 || email.length()>24 || address.length() > 24 || age.length()>2 || name.contains("<") || phone.contains("<") || email.contains("<") || address.contains("<") || age.contains("<")) {
            request.setAttribute("update_msg","格式错误，请重新提交！"+String.format("%tT",new Date()));
            request.getRequestDispatcher("updateStudentServlet?sid="+sid).forward(request, response);
        }else {
            //封装学生对象
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

            //调用studentUpdata服务
            StudentService service= new StudentServiceImpl();
            service.updateInfo(updateStudent);

            //成功则返回并给提示
            request.setAttribute("update_msg", "修改成功！"+String.format("%tT",new Date()));
            request.getRequestDispatcher("updateStudentServlet?sid="+sid).forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
