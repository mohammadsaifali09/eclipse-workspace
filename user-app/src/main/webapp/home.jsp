<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <%
    String status=(String) session.getAttribute("status");
    if(status != null){
    %>
    <h2>
        <a href="">Register</a>
    </h2>
    <h2>
        <a href="">Fetch</a>
    </h2>
    <h2>
        <a href="logout">Logout</a>
    </h2>
    <%
    } else{
    	response.sendRedirect("login.jsp");
    }
    %>
</body>
</html>