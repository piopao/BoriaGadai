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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<title>Choose Profile Picture</title>
</head>
<body>

	<form id="images" action="ChangeProfilePicture" method="post"></form>

	<script>
		function myfun() {
			var html = "";
			for (var i = 1; i <= 16; i++) {
				document.getElementById("images").innerHTML += "<label><input id=\"image" + i 
					+ "\" type=\"radio\" value=\"profilePic" + i + "\" name=\"choice\" /><img id=\"profilePic" + i 
						+ "\" src=\"./avatars/profilePic" + i + "\"></label>";
				document.getElementById("profilePic" + i).style.cssText = "height: 200px; width: 200px;";
			}
			document.getElementById("images").innerHTML += "<button type=\"submit\">დააყენე ფოტო</button>";
		}
		myfun();
	</script>

	<script src="ChatRequest.js"></script>
</body>
</html>

