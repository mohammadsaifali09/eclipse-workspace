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
    String name=(String) session.getAttribute("name");
    int id=(int) session.getAttribute("id");
    long phone=(long) session.getAttribute("phone");
    int age=(int) session.getAttribute("age");
    if(name !=null){
    %>
    <h1>Your Details</h1>
    <h2>Id: <%=id%></h2>
    <h2>Name: <%=name%></h2>
    <h2>Age: <%=age%></h2>
    <h2>Phone: <%=phone%></h2>
    <%
    } else{
    	response.sendRedirect("login.jsp");
    }
    %>
</body>
</html>