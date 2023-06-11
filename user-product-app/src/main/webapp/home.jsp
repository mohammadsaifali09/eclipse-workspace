<%@page import="org.jsp.userproductapp.dto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
	<%
	User user = (User) session.getAttribute("user");
	if (user != null) {
	%>
	<h2>
		Welcome Mr. <%=user.getName()%>
	</h2>
	<h3>
		<a href="editUser.jsp">Edit Your Profile</a>
	</h3>
	<h3>
		<a href="viewUser.jsp">View Your Profile</a>
	</h3>
	<h3>
		<a href="delete">Delete Your Profile</a>
	</h3>
	<h3>
		<a href="logout">Logout</a>
	</h3>
	<h3>
		<a href="addProduct.jsp">Add Product</a>
	</h3>
	<h3>
		<a href="viewproducts">View Products</a>
	</h3>
	<%
	} else {
	response.sendRedirect("login.jsp");
	}
	%>
</body>
</html>