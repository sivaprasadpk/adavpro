<%@page import="com.sathya.servlet.HostelDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- Bootstrap CDN(Content Delivery Network) link to get support of BootStrap -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" />
</head>
<body>

	<c:if test="${previousBookings.size()==0}">
		<h1 class="font-italic font-weight-bold text-success text-center">No
			Previous Bookings</h1>
	</c:if>
	<c:if test="${previousBookings.size()!=0}">
		<table class="table table-bordered table-striped">
			<thead class="thead-dark">
				<tr>
					<th>Booking Id</th>
					<th>Room Type</th>
					<th>Check-In Date</th>
					<th>Check-Out Date</th>
					<th>Duration</th>
					<th>Total rent</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach var="details" items="${previousBookings}">
					<tr>
						<td>${details.bookingId}</td>
						<td>${details.roomType}</td>
						<td>${details.checkInDate}</td>
						<td>${details.checkOutDate}</td>
						<td>${details.duration}</td>
						<td>${details.rent}</td>
					</tr>
				</c:forEach>

			</tbody>

		</table>
	</c:if>
</body>
</html>