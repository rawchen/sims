package web.servlet.student;

import domain.Course;
import domain.SelectCourse;
import domain.Student;
import service.StudentService;
import service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet("/doSelectCourseServlet")
public class DoSelectCourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        Student student= (Student)session.getAttribute("student");
        String courseid = request.getParameter("id");
        //存不存在已选该课
        boolean flag = false;

        //判断是否已选
        StudentService studentService = new StudentServiceImpl();
        List<SelectCourse> selectcourses = studentService.findAllSelectCourse(student.getS_id());
        for (SelectCourse s:selectcourses) {
            if (s.getC_id().equals(courseid)) {
                flag = true;
                break;
            }
        }
        if (flag == true) {

            request.setAttribute("select_msg", "你已选了该课程！" + String.format("%tT", new Date()));
            request.getRequestDispatcher("studentOptionalCourseServlet").forward(request, response);
//            response.sendRedirect("studentOptionalCourseServlet");
        } else {
            //获取到当前学生id
            String studentid = student.getS_id();

            //获取当前行的课程id courseid

            //调用学生添加选课服务s_id c_id score  select_course添加
            StudentService Service = new StudentServiceImpl();
            Service.addSelectCourse(studentid,courseid);

            //完成后给提示跳转
            request.setAttribute("select_msg", "选课成功！" + String.format("%tT", new Date()));
            request.getRequestDispatcher("studentOptionalCourseServlet").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
