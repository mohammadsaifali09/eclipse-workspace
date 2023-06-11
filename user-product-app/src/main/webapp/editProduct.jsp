<%@page import="org.jsp.userproductapp.dto.Product"%>
<%@page import="org.jsp.userproductapp.dto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Product</title>
</head>
<body>
	<%
	User user = (User) session.getAttribute("user");
	if (user != null) {
		Product p = (Product) request.getAttribute("product");
	%>
	<form action="editproduct" method="post">
		<input type="hidden" value="<%=p.getId()%>" name="id">
		Name<input type="text" name="nm" value="<%=p.getName()%>"><br><br>
		Description<input type="text" name="desc" value="<%=p.getDescription()%>"><br><br>
		Brand<input type="text" name="br" value="<%=p.getBrand()%>"><br><br>
		category<input type="text" name="cat" value="<%=p.getCategory()%>"><br><br>
		Image<input type="text" name='im' value="<%=p.getImage()%>"><br><br>
		Price<input type="text" name="price" value="<%=p.getPrice()%>"><br><br>
		<input type="submit" value="Update Product">
	</form>
	<%
	} else {
	response.sendRedirect("login.jsp");
	}
	%>
</body>
</html>