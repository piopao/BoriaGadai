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
	
				<a href="#" id = a1 onclick="breakCookie1();"><img class = coPic id="cookie1" src="./Images/fortune-cookie2.png"
				></a>			
			
				<a id = a2 href="#" onclick="breakCookie2()"><img class = coPic id="cookie2" src="./Images/fortune-cookie2.png"
					></a>		
					
				<a id = a3 href="#" onclick="breakCookie3()"><img class = coPic id="cookie3" src="./Images/fortune-cookie2.png"
					></a>
					
				<a id = a4 href="#" onclick="breakCookie4()"><img class = coPic id="cookie4" src="./Images/fortune-cookie2.png"
					></a>
			
	
		<h2 id="title"> აირჩიე ორცხობილა</h2>
	</div>
	
	<div id="cookieFortune">
		<a href="#" onclick="disappearFortune()">
		<img id="cookie-fortune-img" alt="Fortune Telling" src="./Images/cookie-fortune.png">
		 <span id="fortune" class="fortune">Open frame technology</span>
		 </a>
	</div>

	 <a href="Homepage.jsp">
  <img class = home src="./Images/home.png">
	</a> 
	<div class=scroll>
		<img id=scroll onclick="scrollDownWindow()" class=scroll
			src="./Images/scroll-down.png">
	</div>
	<p id = gameName style = "display:none;">fortunecookie</p>
	<div id=reviewCover class=reviewCover></div>

	<script>
		$(function() {
			$("#reviewCover").load("AddReview.html");
		});
	</script>
	<script src="ChatRequest.js"></script>
</body>
</html>