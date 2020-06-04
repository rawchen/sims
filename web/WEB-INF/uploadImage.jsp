<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<img src="${pageContext.request.contextPath}/showPhotoServlet">
<form action="${pageContext.request.contextPath}/uploadImageServlet" method="post" enctype="multipart/form-data">
    <input  type="file" name="images">
    <button  type="submit"  name="upload">上传</button>
</form>
</body>
</html>