<%@page import="com.sagar.component.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% Product product = (Product) request.getAttribute("product"); %>
	
	<form action="updateById" method="post">
		<fieldset style="width: 100px;">
			<legend>Update Product</legend>
				<input type="number" value="<%= product.getProductId()%>" name="productId" readonly="true"><br>
				<input type="text" value="<%= product.getProductName()%>" name="productName"><br>
				<input type="number" step="0.01" value="<%= product.getProductPrice()%>" name="productPrice"><br>
				<input type="submit" value="Update">
		</fieldset>
	</form>
</body>
</html>