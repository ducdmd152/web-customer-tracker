<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CRM | List customers</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/css/style.css">
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>



		<div id="container">
			<div id="content">

				<!-- put new button: Add Customer -->
				<input type="button" value="Add Customer"
					onclick="window.location.href='showFormForAdd'; return false;"
					class="add-button" />

				<!-- add out html table here -->
				<table>
					<tr>
						<th>First name</th>
						<th>Last name</th>
						<th>Email</th>
						<th>Action</th>
					</tr>

					<c:forEach var="customer" items="${customers}">
						<!-- construct an "update" link with customer.id-->
						<c:url var="updateLink" value="showFormForUpdate">
							<c:param name="customerId"
								value="${customer.id }"/>
						</c:url>

						<tr>
							<td>${customer.firstName }</td>
							<td>${customer.lastName }</td>
							<td>${customer.email }</td>

							<td>
								<!-- display the update link -->
								<a href="${updateLink }">Update</a>
							</td>
						</tr>
					</c:forEach>



				</table>
			</div>
		</div>

	</div>

</body>
</html>