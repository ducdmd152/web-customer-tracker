<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home page</title>
</head>
<body>
	<h1>Main menu</h1>
	
	<c:set var="mm" value="muoi muoi"/>
	
	${pageScope.mm == null}
	${pageScope.mm}
	<a href="SpringMVCTest/welcome">Testing to welcome Spring MVC</a>
	<br><br>
	<a href="customer/list">List customers</a>
</body>
</html>