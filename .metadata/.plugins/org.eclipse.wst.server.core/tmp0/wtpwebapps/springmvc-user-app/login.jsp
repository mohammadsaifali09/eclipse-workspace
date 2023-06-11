<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h2>${msg }</h2>
   <form action="login" method="post">
	    Phone:<input type="tel" name="phone" placeholder="Enter your phone"><br><br>
	    Password:<input type="password" name="password" placeholder="Enter your password"><br><br>
		<input type="submit" value="Login">
	</form>
	<h3><a href="register.jsp">If you are not register click here to register</a></h3>
</body>
</html>