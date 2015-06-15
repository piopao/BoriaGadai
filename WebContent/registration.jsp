<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="Registration.css">
	<title>Registration</title>
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="RegistrationValidation.js"></script>
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</head>
<body>
	<div class = "registration">
		<h2 id = "register">რეგისტრაცია</h2>
		<p id = tryagain>* *</p>
		<form action = "RegistrationServlet" method = "post">
			<div class = "form-group">			
				<input class="form-control" type="text" placeholder = "ელ.ფოსტა"  size="25" value="" id = "email" name = "email">		
			</div>	
			<div class = "form-group">	
				<div class="btn-group">
					<button  type="button" class = "btn btn-default" id = "check">შემოწმება</button>
					<button  type="button"  class = "btn btn-default" id = "change">ელ.ფოსტის შეცვლა</button> 
				</div>				
			</div>
			<div class = "form-group">
				<input  type="password" placeholder = "პაროლი"  value="" class = "form-control"  id = "password" name = "password" >
				<input  type="password" placeholder = "გაიმეორეთ პაროლი"  value="" class = "form-control" id = "password2" name = "password2" >
				<p id = "warning"></p>
			</div>
			<div class = "form-group">
				<input class="form-control" type="text" placeholder = "მომხმარებელი"  size="25" value="" id = "username" name = "username">
				<input class="form-control" type="text" placeholder = "სახელი"  size="25" value="" id = "name" name = "name">	
				<input class="form-control" type="text" placeholder = "გვარი"  size="25" value="" id = "surname" name = "surname">		
			</div>
			<div class = "form-group">
				<button class = "restricted btn btn-default"  onclick = " return validateInfo()" disabled>რეგისტრაცია</button>
			</div>	
		</form>	
	</div>
</body>
</html>