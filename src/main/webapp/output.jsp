<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!--  
	<h1><%= request.getAttribute("message") %></h1><br>
	<h2>Product Id: <%= request.getAttribute("productId") %></h2><br>
	<h2>Product Name: <%= request.getAttribute("productName") %></h2><br>
	<h2>Product Price: <%= request.getAttribute("productPrice") %></h2>
	-->
	<%= request.getAttribute("Products") %>
</body>
</html>