package web.servlet.file;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/uploadServlet")
public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");


        boolean isMultipart=ServletFileUpload.isMultipartContent(request);
        if (isMultipart) {
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setHeaderEncoding("utf-8");

//            upload.setProgressListener(new ProgressListener(){
//                public void update(long pBytesRead, long pContentLength, int pItems) {
//                    ProcessInfo pri = new ProcessInfo();
//                    pri.itemNum = pItems;
//                    pri.readSize = pBytesRead;
//                    pri.totalSize = pContentLength;
//                    pri.show = pBytesRead+"/"+pContentLength+" byte";
//                    pri.rate = Math.round(new Float(pBytesRead) / new Float(pContentLength)*100);
//                    hs.setAttribute("proInfo", pri);
//                }
//            });

            try {
                List<FileItem> items = upload.parseRequest(request);
                Iterator<FileItem> it = items.iterator();
                while (it.hasNext()) {
                    FileItem item = it.next();
                    String itemname = item.getFieldName();
                    int sno = -1;
                    String sname = null;

                    if (item.isFormField()) {
                        if (itemname.equals("sno")) {
                            sno = Integer.parseInt(item.getString("utf-8"));
                        } else if (itemname.equals("sname")) {
                            sname = item.getString("utf-8");
                            sname = item.getName();
                        } else {
                            System.out.println("其他字段");
                        }
                    } else {
                        String filename = item.getName();
                        //String path=request.getSession().getServletContext().getRealPath("upload");
                        String path = this.getServletContext().getRealPath("upload");
                        if (filename.substring(filename.lastIndexOf(".") + 1).equals("jsp")
                                || filename.substring(filename.lastIndexOf(".") + 1).equals("htm")
                                || filename.substring(filename.lastIndexOf(".") + 1).equals("html")) {
                            request.getRequestDispatcher("error.jsp").forward(request, response);
                        } else {
                            System.out.println(path);
                            File file = new File(path);
                            if (!file.exists() && !file.isDirectory()) {
                                file.mkdir();
                            }
                            item.write(new File(path, filename));
                            request.setAttribute("news", filename + "  上传成功!");
                            request.getRequestDispatcher("/WEB-INF/admin/uploadFile.jsp").forward(request, response);
//                        response.sendRedirect("fileUploadIndexServlet");
                            System.out.println(filename + "上传成功!!!");

                        }
                        return;
                    }

                }
            } catch (FileUploadException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class ProcessInfo{
        public long totalSize = 1;
        public long readSize = 0;
        public String show = "";
        public int itemNum = 0;
        public int rate = 0;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
