<%@page import="com.sathya.servlet.BookDetailsDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book</title>
<style type="text/css">
body {
    font-family: Arial, sans-serif;
    background-color: #f2f2f2;
    margin: 0;
    padding: 0;
}

form {
    max-width: 420px;
    margin: 20px auto;
    padding: 20px;
    background-color: #fff;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    border-radius: 5px;
}

h3 {
    text-align:center;
    color: #333;
}

.bold-label {
    font-weight: bold;
}

input[type="text"],
input[type="number"],
input[type="date"] {
    width: 95%;
    padding: 8px;
    margin: 3px 0;
    box-sizing: border-box;
}

input[type="submit"] {
    background-color: #4caf50;
    color: white;
    padding: 10px 15px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
}

input[type="submit"]:hover {
    background-color: #45a049;
}
</style>

<script type="text/javascript">
function bookValidate() {
    var username = document.getElementById('UserName').value;
    var checkInDate = document.getElementById('checkin').value;
    var checkOutDate = document.getElementById('checkout').value;

    // Check if any field is empty
    if (username.trim() === "" || checkInDate.trim() === "" || checkOutDate.trim() === "") {
        alert('Please fill in all the fields.');
        return false;
    }

    // Check if check-in date is not less than today
    var today = new Date().toISOString().split('T')[0];
    if (checkInDate < today) {
        alert('Check-in date should not be less than today.');
        return false;
    }

    // Check if check-out date is not less than check-in date
    if (checkOutDate < checkInDate) {
        alert('Check-out date should not be less than check-in date.');
        return false;
    }

    return true;
}
</script>
</head>
<body>
<form method="post" action="BookingServlet" enctype="multipart/form-data" onsubmit="return bookValidate()">
<h3>Booking page</h3>

<div>
    <label class="bold-label">Available rooms:</label>
    <input type="number" name="rooms" id="rooms" value="<%=new BookDetailsDao().avaliableRooms(request.getParameter("type")) %>" readonly/><br><br>
</div>

<div >
    <label class="bold-label">Username :</label>
    <input type="text" name="UserName" id="UserName" placeholder="enter username" required /><br><br>
</div>

<div>
    <label class="bold-label">Check IN:</label>
    <input type="date" name="checkin" id="checkin"  required /><br><br>
</div>

<div>
    <label class="bold-label">Check Out :</label>
    <input type="date" name="checkout" id="checkout"  required /><br><br>
</div>

<div >
    <label class="bold-label">Aadhaar Image:</label>
    <input type="file" name="proImage" id="adhaarNum"  required /><br><br>
</div>
<input type="hidden" name="type" value="<%=request.getParameter("type") %>">

<center>
<input type="submit" value="book"/>
</center>


</form>

</body>
</html>
