<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<%
	String message = (String) request.getAttribute("msg");
	if (message != null) {
	%>
	<h2>
		<%=message%>
	</h2>
	<%
	}
	%>
	<form action="login" method="post">
		Phone: <input type="tel" name="ph" placeholder="Enter Your Phone Number"><br><br>
		Password: <input type="text" name="ps" placeholder="Enter Your Password"><br><br>
		<input type="submit" value="Login">
	</form>
	<h2>
		<a href="register.jsp">Click here to register</a>
	</h2>
</body>
</html>