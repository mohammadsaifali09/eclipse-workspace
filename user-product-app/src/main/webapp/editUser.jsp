<%@page import="org.jsp.userproductapp.dto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Profile</title>
</head>
<body>
	<%
	User user = (User) session.getAttribute("user");
	if (user != null) {
	%>
	<form action="edit" method="post">
	    <input type="hidden" name="id" value="<%=user.getId()%>"><br><br>
		Name: <input type="text" name="nm" value="<%=user.getName()%>"><br><br>
		Phone: <input type="tel" name="ph" value="<%=user.getPhone()%>"><br><br>
		Email: <input type="email" name="em" value="<%=user.getEmail()%>"><br><br>
		Age: <input type="number" name="age" value="<%=user.getAge()%>"><br><br>
		Password: <input type="password" name="ps" value="<%=user.getPassword()%>"><br><br>
		<input type="submit" value="Update">
	</form>
	<%
	} else {
	response.sendRedirect("login.jsp");
	}
	%>
</body>
</html>