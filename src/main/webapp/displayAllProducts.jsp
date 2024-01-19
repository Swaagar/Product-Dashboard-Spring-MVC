<%@page import="com.sagar.component.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<% List<Product> products = (List) request.getAttribute("productList"); %>

	<table border="1" bgcolor="lightgreen" bordercolor="blue" cellspacing="5px" cellpadding="5px">
		<tr align="center" bgcolor="lightblue">
			<th>Product Id</th>
			<th>Product Name</th>
			<th>Product Price</th>
			<th>UPDATE</th>
			<th>DELETE</th>
		</tr>
		
		<% for(Product product : products){ %>
		
		<tr align="center" bgcolor="lightyellow">
			<td><%= product.getProductId() %></td>
			<td><%= product.getProductName() %></td>
			<td><%= product.getProductPrice() %></td>
			<td><a href="update?productId=<%=product.getProductId()%>">Update</a></td>
			<td><a href="delete?productId=<%=product.getProductId()%>">Delete</a></td>
		</tr>
		
		<% } %>
	</table>
</body>
</html>