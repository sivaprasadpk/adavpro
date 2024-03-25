<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="style.css">
<script src="register_validations.js"></script>
</head>
<body>

	<!-- Navigation Bar -->
	<%@ include file="component/navbar.jsp"%>

	<!-- Registration Form -->
	<div class="container">
		<h2>User Registration</h2>
		<form method="post" action="./RegisterServlet"
			onsubmit="return registerValidations() ">

			<div class="form-group">
				<label for="name" class="form-label">Name:</label> <input
					type="text" name="name" id="name" class="form-control"
					placeholder="Enter name" required>
			</div>
			<div class="form-group">
				<label for="password" class="form-label">Password:</label> <input
					type="password" name="password" id="password" class="form-control"
					placeholder="Enter password" required>
			</div>
			<div class="form-group">
				<label for="confirmpassword" class="form-label">Confirm
					Password:</label> <input type="password" name="confirmpassword"
					id="confirmpassword" class="form-control"
					placeholder="Confirm password" required>
			</div>
			<div class="form-group">
				<label for="email" class="form-label">Email:</label> <input
					type="email" name="email" id="email" class="form-control"
					placeholder="Enter email" required>
			</div>
			<div class="form-group">
				<label for="mobile" class="form-label">Mobile:</label> <input
					type="number" name="mobile" id="mobile" class="form-control"
					placeholder="Enter mobile" required>
			</div>
			<div class="form-group">
				<label for="address" class="form-label">Address:</label>
				<textarea name="address" id="address" class="form-control"
					placeholder="Enter Complete address" rows="4" cols="50" required></textarea>
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-primary">Register</button>
			</div>

			<div class="already-registered">
				<p>
					Already Registered? <a href="login.html">Login Here</a>
				</p>
			</div>
		</form>
	</div>
</body>
</html>