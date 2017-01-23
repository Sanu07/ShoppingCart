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
	WELCOME WEB-INF123
	<button class="btn btn-primary" data-toggle="modal"
		data-target="#registerModal">Register</button>

	<div class="modal fade" id="registerModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title">Register</h4>
				</div>
				<div class="modal-body">
					<form id="registerForm" role="form" action="registerUser"
						method="post">
						<div class="form-group">
							<label for="name">Name:</label> <input type="text"
								class="form-control" id="name" name="name">
						</div>
						<div class="form-group">
							<label for="pwd">Phone Number:</label> <input type="text"
								class="form-control" id="phoneNumber" name="phoneNumber">
						</div>
						<div class="form-group">
							<label for="pwd">Email:</label> <input type="text"
								class="form-control" id="emailId" name="emailId">
						</div>
						<div class="form-group">
							<label for="pwd">Password:</label> <input type="password"
								class="form-control" id="password" name="password">
						</div>
						<input type="submit" value="Register" class="btn btn-default" />
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>

	<button class="btn btn-primary" data-toggle="modal"
		data-target="#loginModal">Login</button>
	<div class="modal fade" id="loginModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title">Login</h4>
				</div>
				<div class="modal-body">
					<form id="loginForm" role="form" action="loginUser" method="post">
						<div class="form-group">
							<label for="name">Phone Number Or Email:</label> <input
								type="text" class="form-control" id="phoneNumberOrEmailId"
								name="phoneNumberOrEmailId">
						</div>
						<div class="form-group">
							<label for="pwd">Password:</label> <input type="password"
								class="form-control" id="password" name="password">
						</div>
						<input type="submit" value="Login" class="btn btn-default" />
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
	<a href="${pageContext.request.contextPath}/updateUserProfile">Update User</a>
</body>
</html>