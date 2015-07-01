<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
 	 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
 	 <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<style type="text/css">
		@import url("NavigationBar.css");
		body{
		background-color: #5a7676;
		}
		img { height: 600px; width: 600px;
			position: absolute;
			margin-top: 5%;
			left: 20px;
		}	
	</style>
</head>
<body>
	<div id="Navigation-bar"></div>

	<script>
		$(function() {
			$("#Navigation-bar").load("NavigationBar.html");
		});
	</script>
	<img src="./Images/paka.png" >
	

</body>
</html>