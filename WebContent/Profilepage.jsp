<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*, authorization.User"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="Profile.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">

<title>Profile</title>
</head>
<body>
	<%
		User currentUser = (User) session.getAttribute("user");
		String status = "loggedin";
	%>

	<!-- Header -->
	<div id="header">
		<div class="container">

			<!-- Logo -->
			<div id="logo">
				<h1>
					<a href="#">ბორია გადაი</a>
				</h1>
			</div>

			<!-- Nav -->
			<nav class="main-nav">
				<div>
					<ul class="nav navbar-nav">
						<li class="active"><a href="Homepage.jsp">მთავარი</a></li>
						<li><form role="search" class="navbar-form navbar-left">
								<div class="form-group">
									<input type="text" class="form-control"
										placeholder="შეიყვანეთ მეილი" size="50">
								</div>
								<button type="submit">ძებნა</button>
							</form></li>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li><a id="user" href="#" onclick="user()"><span
								class="glyphicon glyphicon-user"></span> <%
 	if (currentUser == null)
 		out.print("სტუმარი");
 	else
 		out.print(currentUser.getEmail());
 %></a></li>
						<li>
							<form id="myForm" action="">
								<button id="logBut" type="submit" onclick="login()"
									class="btn btn-link btn-lg">
									<span class="glyphicon glyphicon-log-in"></span>
									<%
										if (currentUser == null)
											out.print("შესვლა");
										else
											out.print("გამოსვლა");
									%>
								</button>
							</form>
						</li>
					</ul>
				</div>
			</nav>
		</div>
	</div>


	<script>
	function user(){
		var status = '<%=status%>';
		if(status == "loggedout")
			document.getElementById("user").href = "#";
		else
		document.getElementById("user").href = "Profilepage.jsp";
	</script>


	<script>
		function login() {
			var status = '<%=status%>';
			if (status == "loggedout") {
				document.getElementById("myForm").action = "Login.jsp";
			} else {
	<%currentUser = null;
			session.setAttribute("user", null);
			session.setAttribute("logStatus", "loggedout");%>
		document.getElementById("myForm").action = "Homepage.jsp";
			}
		}
	</script>






	
		<div class="col-sm-3 text-center">
			<div>
				<img src="./Images/cloud.png" alt="Lottery Ticket" id="profilePic">
			</div>
			<h2>Nino Basilaia</h2>
			<table class="table table-striped table-hover">
				<tbody>
					<tr>
						<td><a href="#">მესიჯები</a></td>
						<td style="width: 30%;"><span
							class="glyphicon glyphicon-envelope"></span></td>
					</tr>
					<tr>
						<td><a href="#">ნოტიფიკაციები</a></td>
						<td><span class="glyphicon glyphicon-globe"></span></td>
					</tr>
					<tr>
						<td><a href="#">რეიტინგი</a></td>
						<td><i><span class="glyphicon glyphicon-star"></span></i> <i><span
								class="glyphicon glyphicon-star"></span></i> <i><span
								class="glyphicon glyphicon-star"></span></i> <i><span
								class="glyphicon glyphicon-star"></span></i></td>
					</tr>
					<tr>
						<td><a href="#">მეგობრები</a></td>
						<td><span class="glyphicon glyphicon-user"></span></td>
					</tr>
				</tbody>
			</table>
		</div>
	



		<div>
			<table>
				<tr>
					<td><h3>პირადი ინფორმაცია</h3></td>
					<td><a href="#"><span class="glyphicon glyphicon-edit"></span>
							Edit </a></td>
				</tr>
			</table>
		</div>
		<div class="row row-pos">
			<div class="col-sm-6">
				<label class="col-xs-5 control-label">სახელი:</label>
				<div class="col-xs-7 controls">ნინო</div>
			</div>
			<div class="col-sm-6">
				<label class="col-xs-5 control-label">გვარი:</label>
				<div class="col-xs-7 controls">ბასილაია</div>
			</div>
			<div class="col-sm-6">
				<label class="col-xs-5 control-label">ელ. ფოსტა:</label>
				<div class="col-xs-7 controls">nbasi13@freeuni.edu.ge</div>
			</div>
			<div class="col-sm-6">
				<label class="col-xs-5 control-label">ქალაქი:</label>
				<div class="col-xs-7 controls">თბილისი</div>
			</div>
			<div class="col-sm-6">
				<label class="col-xs-5 control-label">ქვეყანა:</label>
				<div class="col-xs-7 controls">საქართველო</div>
			</div>
			<div class="col-sm-6">
				<label class="col-xs-5 control-label">დაბადების თარიღი:</label>
				<div class="col-xs-7 controls">3 ივნისი 1995 წ.</div>
			</div>
			<div class="col-sm-6">
				<label class="col-xs-5 control-label">ტელ:</label>
				<div class="col-xs-7 controls">2334649</div>
			</div>
			<div class="col-sm-6">
				<p id="about-me" class="container">mokled dzaaan magari roja var
					da vabshe vin xar</p>
			</div>

		</div>


	<div class="container">
		<h2>Fortune Telling</h2>
		<p>You can either predict your future, find out you lucky numbers
			or even see you lucky weather for today ^^</p>
		<div class="row">
			<div class="col-md-4">
				<a href="Lottery.html"> Get Your Lucky Numbers For The Lottery
					Ticket <img src="./Images/cloud.png" alt="Lottery Ticket"
					style="width: 150px; height: 150px">
				</a>
			</div>
			<div class="col-md-4">
				<a href="TarotPrediction.jsp"> Predict your future by Tarot card
					reading <img src="./Images/rain.png" alt="Tarot Reading"
					style="width: 150px; height: 160px">
				</a>
			</div>
			<div class="col-md-4">
				<a href="Weather.html"> Find out your lucky weather for today! <img
					src="./Images/sun.jpg" alt="weather forecast"
					style="width: 150px; height: 160px">
				</a>
			</div>
		</div>
	</div>


</body>
</html>

