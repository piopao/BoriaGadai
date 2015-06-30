<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="FortuneCookie.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Fortune Cookie</title>
<script src="FortuneCookie.js"></script>
</head>
<body>
	<div class="container cookies zoom_img">
		<h2 id="title">აირჩიე ორცხობილა</h2>
		<div class="row">
			<div class="col-md-4 cookie">
				<a href="#" onclick="breakCookie1();"><img id="cookie1" src="./Images/fortune-cookie.png"
					style="width: 150px; height: 160px"></a>
			</div>
			<div class="col-md-4 cookie">
				<a href="#" onclick="breakCookie2()"><img id="cookie2" src="./Images/fortune-cookie.png"
					style="width: 150px; height: 160px"></a>
			</div>
			<div class="col-md-4 cookie">
				<a href="#" onclick="breakCookie3()"><img id="cookie3" src="./Images/fortune-cookie.png"
					style="width: 150px; height: 160px"></a>
			</div>
			<div class="col-md-4 cookie">
				<a href="#" onclick="breakCookie4()"><img id="cookie4" src="./Images/fortune-cookie.png"
					style="width: 150px; height: 160px"></a>
			</div>
		</div>
	</div>
	
	<div id="cookieFortune">
		<a href="#" onclick="disappearFortune()">
		<img id="cookie-fortune-img" alt="Fortune Telling" src="./Images/cookie-fortune.png">
		 <span id="fortune" class="fortune">Open frame technology</span>
		 </a>
	</div>

	<div class=scroll>
		<img id=scroll onclick="scrollDownWindow()" class=scroll
			src="./Images/scroll-down.png">
	</div>

	<div id=reviewCover class=reviewCover></div>

	<script>
		$(function() {
			$("#reviewCover").load("AddReview.html");
		});
	</script>
</body>
</html>