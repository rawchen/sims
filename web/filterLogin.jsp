<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TITLE</title>
</head>
<body>
<%
    if (session.getAttribute("student")==null && session.getAttribute("teacher")==null && session.getAttribute("admin")==null) {
%>
        <jsp:forward page = "login.jsp"/>
<%
    }
%>

</body>
</html>
