<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% response.sendRedirect("customer/list"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home page</title>
</head>
<body>
	<h1>Main menu</h1>
	
	<a href="SpringMVCTest/welcome">Testing to welcome Spring MVC</a>
	<br><br>
	<a href="customer/list">List customers</a>
</body>
</html>