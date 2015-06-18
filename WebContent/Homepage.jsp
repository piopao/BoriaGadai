<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*, authorization.User"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">

<title>Home</title>
</head>
<body>
	<%
		User currentUser = null;
		String status = "loggedout";
		if (session.getAttribute("user") != null) {
			currentUser = (User) session.getAttribute("user");
			status = "loggedin";
		}
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
			<nav id="navigation-bar">
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
						%> </a></li>
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
}
</script>

	<script>
		function login() {
			var status = '<%=status%>';
			if(status == "loggedout") {
				document.getElementById("myForm").action = "Login.jsp";
			} else {
				//FB.logout(function(response){
				 //   console.log(response);
				//});
			<%currentUser = null;
			session.setAttribute("user", null);
			session.setAttribute("logStatus", "loggedout");%>
			document.getElementById("myForm").action = "Homepage.jsp";
			}
		}
	</script>


	<div>
		<h2>Fortune Telling</h2>
		<p>You can either predict your future, find out you lucky numbers
			or even see you lucky weather for today ^^</p>
		<div>
			<div>
				<a href="Lottery.html"> Get Your Lucky Numbers For The Lottery
					Ticket <img src="./Images/cloud.png" alt="Lottery Ticket"
					style="width: 150px; height: 150px">
				</a>
			</div>
			<div>
				<a href="TarotPrediction.jsp"> Predict your future by Tarot card
					reading <img src="./Images/rain.png" alt="Tarot Reading"
					style="width: 150px; height: 160px">
				</a>
			</div>
			<div>
				<a href="Weather.html"> Find out your lucky weather for today! <img
					src="./Images/sun.jpg" alt="weather forecast"
					style="width: 150px; height: 160px">
				</a>
			</div>
		</div>
	</div>



</body>
</html>

