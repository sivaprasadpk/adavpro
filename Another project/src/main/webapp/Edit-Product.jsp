<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Base64"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script type="text/javascript" src="formValidation.js"></script>
</head>
<body>
	<div class="container mt-5 text-center">
		<h2 class="text-center font-italic mb-1">Save Product Data...</h2>
		<form method="post" action="UpdateProductServlet"
			enctype="multipart/form-data" onsubmit="return formvalidation()">


			<div class="form-group">
				<label class="font-italic font-weight-bold" for="proId">ProductId:</label>
				<input type="text" name="proId" id="proId" value="${existing.proId}"
					class="form-control-sm">
			</div>

			<div class="form-group">
				<label class="font-italic font-weight-bold" for="proName">ProductName:</label>
				<input type="text" name="proName" id="proName"
					class="form-control-sm" value="${existing.proName}">
			</div>

			<div class="form-group">
				<label class="font-italic font-weight-bold" for="proPrice">ProductPrice:</label>
				<input type="number" name="proPrice" id="proPrice"
					class="form-control-sm" value="${existing.proPrice}">
			</div>

			<div class="form-group">
				<label class="font-italic font-weight-bold" for="proBrand">ProductBrand:</label>
				<input type="text" name="proBrand" id="proBrand"
					class="form-control-sm" value="${existing.proBrand}">
			</div>

			<div class="form-group">
				<label class="font-italic font-weight-bold" for="Product MadeIn">Product
					MadeIn:</label> <input type="text" name="proMadein" id="proMadein"
					class="form-control-sm" value="${existing.proMadein}">
			</div>

			<div class="form-group">
				<label class="font-italic font-weight-bold" for="MfgDate">MfgDate:</label>
				<input type="date" name="MfgDate" id="MfgDate"
					class="form-control-sm" value="${existing.proMfgDate}">
			</div>

			<div class="form-group">
				<label class="font-italic font-weight-bold" for="ExpriyDate">ExpriyDate:</label>
				<input type="date" name="Expiry" id="Expiry" class="form-control-sm"
					value="${existing.proExpDate}">
			</div>
			<!--  display the current product image -->
			<div class="form-group">
				<label class="font-italic font-weight-bold" for="ProductImage">Current
					ProductImage:</label> <img id="current image"
					src="data:image/jpeg;base64,${Base64.getEncoder().encodeToString(existing.proImage)}"
					alt="old image">
				<input type="hidden" name="existingImage" id="existingImage"
					alt="Current ProductImage"  value="${Base64.getEncoder().encodeToString(existing.proImage)}"/>
			</div>

			<!--  allow the user to upload image -->
			<div class="form-group">
				<label class="font-italic font-weight-bold" for="ProductImage">New
					ProductImage:</label> <input type="file" name="proImage" id="proImage"
					class="form-control-sm" accept="image/*">

			</div>
		            <!-- Display the current product audio -->
            <div class="form-group">
                <label class="font-italic font-weight-bold" for="currentAudio">Current ProductAudio:</label>
                <audio controls id="currentAudio">
                    <source src="data:audio/mpeg;base64,${Base64.getEncoder().encodeToString(existing.proAudio)}" type="audio/mpeg">
                </audio>
                <input type="hidden" name="existingAudio" id="existingAudio" value="${Base64.getEncoder().encodeToString(existing.proAudio)}"/>
            </div>

            <!-- Allow the user to upload a new audio -->
            <div class="form-group">
                <label class="font-italic font-weight-bold" for="newproVideo">New ProductAudio:</label>
                <input type="file" name="newproAudio" id="newproAudio" class="form-control-sm" accept="audio/*">
            </div>
            
            <!-- Display the current product audio -->
            <div class="form-group">
                <label class="font-italic font-weight-bold" for="currentVideo">Current ProductVideo:</label>
                <video controls id="currentVideo">
                    <source src="data:video/mp4;base64,${Base64.getEncoder().encodeToString(existing.proVideo)}" type="video/mp4">
                </video>
                <input type="hidden" name="existingVideo" id="existingVideo" value="${Base64.getEncoder().encodeToString(existing.proVideo)}"/>
            </div>

            <!-- Allow the user to upload a new video -->
            <div class="form-group">
                <label class="font-italic font-weight-bold" for="newproAudio">New ProductVideo:</label>
                <input type="file" name="newproVideo" id="newproVideo" class="form-control-sm" accept="video/*">
            </div>
            
			
			
			<div>
				<input type="submit" class="btn btn-primary" value="update">
			</div>
		</form>
	</div>

</body>
</html>