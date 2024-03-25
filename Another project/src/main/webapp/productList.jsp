<%@page import="com.sathya.servlet.ProductDao" import="java.util.Base64"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product List</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

</head>
<body>
<div class="font-italic font-weight-bold">
	<h1 class="text-center font-italic mb-1">List of Products</h1>
</div>
<input type="text" placeholder="search">
<div class="text-right">
<a href="Add-Product.html" class="btn btn-primary">Save Product</a><br><br>
</div>
<div>
	<c:if test="${saveresult==1}">
	<h3 class="text-success text-center">Data insertion success</h3>
	</c:if>
</div>
<div>
	<c:if test="${deleteresult==1}">
	<h3 class="text-danger text-center">Data delete success</h3>
	</c:if>
</div>

<div>
	<c:if test="${result==1}">
	<h3 class="text-success text-center">Data updated success</h3>
	</c:if>
</div>

	<table class="table table-bordered table-striped">
		<thead class="thead-dark">
			<tr>
				<th>Product Id</th>
				<th>Product Name</th>
				<th>Product Price</th>
				<th>Product Brand</th>
				<th>Product Madein</th>
				<th>Manufacture Date</th>
				<th>Expiry Date</th>
				<th>Image</th>
				<th>Audio</th>
				<th>Video</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="product" items="<%=new ProductDao().findAll()%>">
				<tr>
					<td>${product.proId}</td>
					<td>${product.proName}</td>
					<td>${product.proPrice}</td>
					<td>${product.proBrand}</td>
					<td>${product.proMadein}</td>
					<td>${product.proMfgDate}</td>
					<td>${product.proExpDate}</td>
					<td><img
						src="data:image/jpeg;base64,${Base64.getEncoder().encodeToString(product.proImage)}"
						alt="product Image" width="50%" height="50%">
					</td>
					
					<td>
        				<audio controls>
        				<source src="data:audio/mpeg;base64,${Base64.getEncoder().encodeToString(product.proAudio) }" type="audio/mpeg">
        				</audio>
        			</td>
        
       			    <td>
        				<video controls width="320" height="240" >
        				<source src="data:video/mp4;base64,${Base64.getEncoder().encodeToString(product.proVideo)}" type="video/mp4">  
              			</video>
       			   </td>
					
					<td><a class="btn btn-primary" href="DeleteProductServlet?proId=${product.proId}">Delete</a>
					<a class="btn btn-primary" href="EditProductServlet?proId=${product.proId}">Edit</a>
		
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>