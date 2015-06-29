<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*, authorization.User"%>
<!DOCTYPE html>
<html>
<head>
<script src="ExternalLogin.js"></script>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta name="google-signin-client_id"
	 content="360066525699-udo2lm0hrdvgd8uconqsg9l54dnbgrdh.apps.googleusercontent.com">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="Homepage.css">
<title>Home</title>
</head>
<body>

	<div id="Navigation-bar"></div>

	<script>
		$(function() {
			$("#Navigation-bar").load("NavigationBar.html");
		});
	</script>
		
	<!-- google signout code -->
	
    <div id="divCheckbox" style="display: none;"><div class="g-signin2" data-onsuccess="onSignIn"></div></div>
	<script>function signOut() {
	    var auth2 = gapi.auth2.getAuthInstance();
	    auth2.signOut().then(function () {
	    });
	  }</script>
	
	<!--  end of google signout code -->


	<div class="container fortune-tellings">
		<h2>Fortune Telling</h2>
		<p>You can either predict your future, find out you lucky numbers
			or even see you lucky weather for today ^^</p>
		<div class="row">
			<div class="col-md-4">
				<a href="GameDescription.jsp?gameName=lottery&gameLink=Lottery.html"> ლატარიააა
					Ticket <img src="./Images/cloud.png" alt="Lottery Ticket"
					style="width: 150px; height: 150px">
				</a>
			</div>
			<div class="col-md-4">
				<a href="TarotPrediction.jsp"> ტარო
					reading <img src="./Images/rain.png" alt="Tarot Reading"
					style="width: 150px; height: 160px">
				</a>
			</div>
			<div class="col-md-4">
				<a href="GameDescription.jsp?gameName=weather&gameLink=Weather.html"> ამინდი <img
					src="./Images/sun.jpg" alt="weather forecast"
					style="width: 150px; height: 160px">
				</a>
			</div>
		</div>
	</div>

		<div class="col-xs-1 popularUsers">
		<h1 class="pop-users">პოპულარული მომხმარებლები</h1>
			<table class="table table-hover">
				<tbody>
					<tr>
						<td><a href="#">megobari1</a></td>
					</tr>
					<tr>
						<td><a href="#">megobari2</a></td>
					</tr>
					<tr>
						<td><a href="#">megobari3</a></td>
					</tr>
					<tr>
						<td><a href="#">megobari4</a></td>
					</tr>
				</tbody>
			</table>
		</div>
		
<script src="ChatRequest.js"></script>
<script src="checkUser.js"></script>
</body>
</html>

