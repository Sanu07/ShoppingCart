<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container" style="margin-top: 20px; width: 50%">
		<form id="updateUserForm" role="form" action="updateUserProfile"
			method="post">
			<div class="form-group">
				<label for="loginId">Login Id:</label> <input type="text"
					class="form-control" id="loginId" name="loginId">
			</div>
			<div class="form-group">
				<label for="name">Name:</label> <input type="text"
					class="form-control" id="name" name="name">
			</div>
			<div class="form-group">
				<label for="phoneNumber">Phone Number:</label> <input type="text"
					class="form-control" id="phoneNumber" name="phoneNumber">
			</div>
			<div class="form-group">
				<label for="emailId">Email:</label> <input type="text"
					class="form-control" id="emailId" name="emailId">
			</div>
			<div class="form-group">
				<label for="password">Password:</label> <input type="password"
					class="form-control" id="password" name="password">
			</div>
			<input type="submit" value="Update Profile" class="btn btn-default" />
		</form>
	</div>
</body>
</html>