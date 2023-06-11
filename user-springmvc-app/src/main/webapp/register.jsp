<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="save" method="post">
		Name:<input type="text" name="name" placeholder="Enter your name"><br><br>
		Phone:<input type="tel" name="phone" placeholder="Enter your phone"><br><br>
		Password:<input type="password" name="password" placeholder="Enter your password"><br><br>
		<input type="submit" value="Register">
	</form>
	<h3><a href="login.jsp">If you are already register click here to login</a></h3>
</body>
</html>