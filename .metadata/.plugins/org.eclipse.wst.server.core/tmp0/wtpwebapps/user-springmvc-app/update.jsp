<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${u!=null }">
			<form action="update" method="post">
				<input type="hidden" name="id" value="${u.getId() }"><br><br>
				Name:<input type="text" name="name" value="${u.getName() }"><br><br>
				Phone:<input type="tel" name="phone" value="${u.getPhone() }"><br><br>
				Password:<input type="password" name="password" value="${u.getPassword() }"><br><br>
				<input type="submit" value="Update">
			</form>
		</c:when>
		<c:otherwise>
			<%
			response.sendRedirect("login.jsp");
			%>
		</c:otherwise>
	</c:choose>
</body>
</html>