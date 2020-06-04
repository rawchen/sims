package web.servlet.file;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageDecoder;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import domain.Photo;
import domain.Student;
import domain.Teacher;
import service.PhotoService;
import service.impl.PhotoServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.ServerSocket;

@WebServlet("/showPhotoServlet")
public class ShowPhotoServlet extends HttpServlet {
    private static final String GIF = "image/gif;charset=GB2312";// 设定输出的类型

    private static final String JPG = "image/jpeg;charset=GB2312";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String spec = request.getParameter("spec");// 输出图片的类型的标志

        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        Student student = (Student) session.getAttribute("student");
        Teacher teacher = (Teacher) session.getAttribute("teacher");
        Photo p;
        if (student != null) {
            PhotoService service = new PhotoServiceImpl();
            p = service.findPhotoByPhotoId(student.getS_id());
        }else{
            PhotoService service = new PhotoServiceImpl();
            p = service.findPhotoByPhotoId(teacher.getT_id());
        }
        String imagePath = "";
        if (p == null) {
            imagePath = this.getServletContext().getRealPath("/photos/") + "0.jpg";
            System.out.println(imagePath);
        } else {
            String photoName = p.getPhotoName();
            imagePath = this.getServletContext().getRealPath("/photos/") + photoName;
            System.out.println(imagePath);
        }


        response.reset();

        OutputStream output = response.getOutputStream();// 得到输出流
        if (imagePath.toLowerCase().endsWith(".jpg"))// 使用编码处理文件流的情况：
        {
            response.setContentType(JPG);// 设定输出的类型
            // 得到图片的真实路径

            // 得到图片的文件流
            InputStream imageIn = new FileInputStream(new File(imagePath));
            // 得到输入的编码器，将文件流进行jpg格式编码
            JPEGImageDecoder decoder = JPEGCodec.createJPEGDecoder(imageIn);
            // 得到编码后的图片对象
            BufferedImage image = decoder.decodeAsBufferedImage();
            // 得到输出的编码器
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(output);
            encoder.encode(image);// 对图片进行输出编码
            imageIn.close();// 关闭文件流
        }

        if (imagePath.toLowerCase().endsWith(".gif"))// 不使用编码处理文件流的情况：
        {
            response.setContentType(GIF);
            ServletContext context = getServletContext();// 得到背景对象
            InputStream imageIn = context.getResourceAsStream(imagePath);// 文件流
            BufferedInputStream bis = new BufferedInputStream(imageIn);// 输入缓冲流
            BufferedOutputStream bos = new BufferedOutputStream(output);// 输出缓冲流
            byte data[] = new byte[4096];// 缓冲字节数
            int size = 0;
            size = bis.read(data);
            while (size != -1) {
                bos.write(data, 0, size);
                size = bis.read(data);
            }
            bis.close();
            bos.flush();// 清空输出缓冲流
            bos.close();
        }
        output.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
