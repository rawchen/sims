package web.servlet.file;

import domain.Admin;
import domain.Photo;
import domain.Student;
import domain.Teacher;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import service.PhotoService;
import service.impl.PhotoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

@WebServlet("/uploadImageServlet")
public class UploadImageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        Student student = (Student) session.getAttribute("student");
        Teacher teacher = (Teacher) session.getAttribute("teacher");
        Admin admin = (Admin) session.getAttribute("admin");
        String id = "";
        if (student != null) {
            id = student.getS_id();
        }

        request.setAttribute("message", "");
        request.setAttribute("path", "");
        String filename = null;
        String newFileName = null;
        // 设置上传图片的保存路径
        String savePath = this.getServletContext().getRealPath("/photos");
        File file = new File(savePath);
        // 判断上传文件的保存目录是否存在
        if (!file.exists() && !file.isDirectory()) {
            System.out.println(savePath + "目录不存在，需要创建");
            // 创建目录
            file.mkdir();
        }
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // 2、创建一个文件上传解析器
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setHeaderEncoding("UTF-8");
        // 3、判断提交上来的数据是否是上传表单的数据
        if (!ServletFileUpload.isMultipartContent(request)) {
            // 按照传统方式获取数据
            return;
        }
        try {
            List<FileItem> list = upload.parseRequest(request);
            System.out.println(list.toString());// 文件的路径 以及保存的路径
            for (FileItem item : list) {
                filename = item.getName();// 获得一个项的文件名称
                try {
                    newFileName = id + filename.substring(filename.lastIndexOf("."));
                    filename = id + filename.substring(filename.lastIndexOf("."));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (filename == null || filename.trim().equals("")) {// 如果為空則跳過
                    continue;
                }
                // 報錯 需要過濾文件名稱 java.io.FileNotFoundException:
                // G:\测试02\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\FaceUp\WEB-INF\images\C:\Users\Ray\Pictures\2.jpeg
                // (文件名、目录名或卷标语法不正确。)

                filename = filename.substring(filename.lastIndexOf("\\") + 1);
//				System.out.print(filename);
                if (filename.substring(filename.lastIndexOf(".") + 1).equals("JPG")
                        || filename.substring(filename.lastIndexOf(".") + 1).equals("JPEG")
                        || filename.substring(filename.lastIndexOf(".") + 1).equals("gif")
                        || filename.substring(filename.lastIndexOf(".") + 1).equals("GIF")
                        || filename.substring(filename.lastIndexOf(".") + 1).equals("jpg")
                        || filename.substring(filename.lastIndexOf(".") + 1).equals("jpeg")) {
                    InputStream in = item.getInputStream();// 獲得上傳的輸入流
                    FileOutputStream out = new FileOutputStream(savePath + "\\" + filename);// 指定web-inf目錄下的images文件
                    request.setAttribute("path",  "photos"+"\\" + filename);

                    int len = 0;
                    byte buffer[] = new byte[1024];
                    while ((len = in.read(buffer)) > 0)// 每次讀取
                    {
                        out.write(buffer, 0, len);
                    }
                    in.close();
                    out.close();
                    item.delete();
                } else {  //必须是图片才能上传否则失败
                    request.setAttribute("update_msg", "上传失败，只能上传类型为jpg或GIF的图像文件！"+String.format("%tT",new Date()));
//        request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
                    request.getRequestDispatcher("/WEB-INF/student/studentAddPhoto.jsp").forward(request, response);
                    return;
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }

        Photo photo = new Photo();
        photo.setPhotoId(id);
        photo.setPhotoName(newFileName);
        PhotoService service = new PhotoServiceImpl();


        Photo photo1= service.findPhotoByPhotoId(id);
        if (photo1==null) {
            service.addPhoto(photo);
        }else {
            service.updatePhoto(photo);
        }
        request.setAttribute("update_msg", "上传成功！"+String.format("%tT",new Date()));
//        request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
        request.getRequestDispatcher("/WEB-INF/student/studentAddPhoto.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/student/studentAddPhoto.jsp").forward(request, response);
    }
}
