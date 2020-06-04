package web.servlet.teacher;

import domain.Teacher;
import service.TeacherService;
import service.impl.TeacherServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/addTeacherInfoServlet")
public class AddTeacherInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        TeacherService service= new TeacherServiceImpl();
        //先进行判断是否已存在该教师
        String tid = request.getParameter("teacher-id");
        Teacher t = new Teacher();
        t.setT_id(tid);
        Teacher newTeacher = service.findTeacherById(t);
        if (newTeacher != null) {
            request.setAttribute("update_msg","已存在该教师，请重新添加！"+String.format("%tT",new Date()));
            request.getRequestDispatcher("addTeacherServlet").forward(request, response);
        }else {
            String name = request.getParameter("teacher-name");
            String sex = request.getParameter("teacher-sex");
            String education = request.getParameter("teacher-education");
            String title = request.getParameter("teacher-title");

//            String college = request.getParameter("selectCollege");
//            String department = request.getParameter("selectDepartment");
//            String cclass = request.getParameter("selectClass");
//            if ("".equals(college)) {
//                college = "待分配";
//            }
//            if ("".equals(department)) {
//                department = "待分配";
//            }
//            if ("".equals(cclass)) {
//                cclass = "待分配";
//            }

            Teacher updateTeacher = new Teacher();

            updateTeacher.setT_id(tid);
            updateTeacher.setT_name(name);
            updateTeacher.setT_sex(sex);
            updateTeacher.setT_education(education);
            updateTeacher.setT_title(title);
//            updateTeacher.setT_college(college);
//            updateTeacher.setT_department(department);
//            updateTeacher.setT_class(cclass);

            service.addTeacherAllInfo(updateTeacher);
            request.setAttribute("update_msg", "添加成功！" + String.format("%tT", new Date()));
            request.getRequestDispatcher("addTeacherServlet").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
