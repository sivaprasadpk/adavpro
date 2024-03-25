<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Billing Invoice</title>
<link rel="stylesheet" type="text/css" href="style2.css">
</head>
<body>
	<h1 class="font-italic font-weight-bold text-Info text-center">
		Billing Invoice......</h1>
	<table>
		<tr>
			<td>Type of Room</td>
			<td>${typeOfRoom}</td>
		</tr>
		<tr>
			<td>Room Rent Per day</td>
			<td>${rentPerDay}</td>
		</tr>
		<tr>
			<td>Check In date</td>
			<td>${checkInDate}</td>
		</tr>
		<tr>
			<td>Check Out date</td>
			<td>${checkOutDate}</td>
		</tr>
		<tr>
			<td>Duration</td>
			<td>${duration}</td>
		</tr>
		<tr>
			<td>Total rent</td>
			<td>${totalRent}</td>
		</tr>
		<tr>
			<td>CGST</td>
			<td>${cgst}</td>
		</tr>
		<tr>
			<td>SGST</td>
			<td>${sgst}</td>
		</tr>
		<tr>
			<td>Discount</td>
			<td>${discount}</td>
		</tr>
		<tr>
			<td>Total Amount to Pay</td>
			<td>${totalPrice}</td>
		</tr>

	</table>
</body>
</html>