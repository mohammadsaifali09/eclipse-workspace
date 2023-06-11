<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
	<c:choose>
		<c:when test="${u!=null }">
			<h2>
				<a href="viewUser.jsp">View User</a>
			</h2>

			<h2>
				<a href="update.jsp">Update User</a>
			</h2>

			<h2>
				<a href="delete?id=${u.getId() }">Delete User</a>
			</h2>

			<h2>
				<a href="logout">Logout</a>
			</h2>
		</c:when>
		<c:otherwise>
			<%
			response.sendRedirect("login.jsp");
			%>
		</c:otherwise>
	</c:choose>
</body>
</html>
