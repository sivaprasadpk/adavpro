<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>User Login</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="style.css">

</head>
<body>

	<!-- Navigation Bar -->
	<%@ include file="component/navbar.jsp"%>

	<!-- Login Form -->
	<div class="container">
		<h2>User Login</h2>
		<form method="post" action="LoginServlet">
			<c:if test="${result==0}">
				<h1 class="font-italic font-weight-bold text-danger text-center">
					Invalid Credentials.... Login Failed</h1>
			</c:if>
			<div class="form-group">
				<label for="username" class="form-label">Username:</label> <input
					type="text" name="username" id="username" class="form-control"
					placeholder="Enter username" required>
			</div>
			<div class="form-group">
				<label for="password" class="form-label">Password:</label> <input
					type="password" name="password" id="password" class="form-control"
					placeholder="Enter password" required>
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-primary">Login</button>
			</div>

			<div class="already-registered">
				<p>
					New To Hostel? <a href="register.html">Register Here</a>
				</p>
			</div>
		</form>
	</div>
</body>
</html>
