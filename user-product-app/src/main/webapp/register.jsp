<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
</head>
<body>
    <form action="reg" method="post">
		Name: <input type="text" name="nm" placeholder="Enter Your Name"><br><br>
		Phone: <input type="tel" name="ph" placeholder="Enter Your Phone Number"><br><br>
		Email: <input type="email" name="em" placeholder="Enter Your Email"><br><br>
		Age: <input type="number" name="age" placeholder="Enter Your Age"><br><br>
		Gender: Male<input type="radio" name="gender" value="Male">
		        Female<input type="radio" name="gender" value="Female"><br><br>
		Password: <input type="password" name="ps" placeholder="Enter Your Password"><br><br>        
		<input type="submit" value="Register">
	</form>
</body>
</html>