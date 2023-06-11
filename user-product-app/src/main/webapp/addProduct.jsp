<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Product</title>
</head>
<body>
   <form action="addProduct" method="post">
		Name: <input type="text" name="nm" placeholder="Enter Product Name"><br><br>
		Description: <input type="text" name="desc" placeholder="Enter Product Description"><br><br>
		Brand: <input type="text" name="br" placeholder="Enter Product Brand"><br><br>
		Category: <input type="text" name="cat" placeholder="Enter Product Category"><br><br>
		Image: <input type="text" name="im"><br><br>
		Price: <input type="text" name="price" placeholder="Enter Product Price"><br><br>        
		<input type="submit" value="Add Product">
	</form>
</body>
</html>