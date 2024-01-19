<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="AddProduct" method="post">
		<fieldset style="width: 100px;">
			<legend>Add Product</legend>
				<input type="number" placeholder="Enter Product Id" name="productId"><br>
				<input type="text" placeholder="Enter ProductName" name="productName"><br>
				<input type="number" step="0.01" placeholder="Enter Product Price" name="productPrice"><br>
				<input type="submit" value="Add">
		</fieldset>	
	</form>
</body>
</html>