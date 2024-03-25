<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Book Rooms</title>
</head>
<style>
.form-group label {
	font-weight: bold;
}
</style>
<body>
	<div class="container mt-5">
		<form method="post" action="BookingServlet" class="col-md-6 mx-auto" enctype="multipart/form-data" >

			<div class="form-group">
				<label for="checkIn">Check In Date:</label> <input type="date"
					name="checkIn" id="checkIn" class="form-control" value="<%=LocalDate.now() %>" required>
			</div>

			<div class="form-group">
				<label for="checkOut">Check Out Date:</label> <input type="date"
					name="checkOut" id="checkOut" class="form-control" required>
			</div>

			<div class="form-group">
				<label for="adhaarFront">Adhaar Front:</label> <input type="file"
					name="adhaarFront" id="adhaarFront" class="form-control"
					accept="image/*" required>
			</div>
			
			<div class="form-group">
				<label for="adhaarBack">Adhaar Back:</label> <input type="file"
					name="adhaarBack" id="adhaarBack" class="form-control"
					accept="image/*" required>
			</div>

			<input type="hidden" id="price1" name="price1" value="${price1 }">
			<input type="hidden" id="price2" name="price2" value="${price2 }">
			<input type="hidden" id="price3" name="price3" value="${price3 }">
			<input type="hidden" id="username" name="username" value="${username }">
			<%String type=request.getParameter("type");
			request.setAttribute("room", type);
			%>
			<input type="hidden" id="room" name="room" value="<%=request.getParameter("type")%>">
	
			<input type="submit" class="btn btn-primary" value="Book">

		</form>
	</div>
</body>
</html>
