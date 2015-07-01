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
		background-color: #0e1e2f;
		}	
		img { height: 500px; width: 500px;
			position: absolute;
			margin-top: 5%;
			left: 20px;
		}		
		h4 {
		 color: white;		  		
		}
  		.error {
  			position: absolute;
   		 	left: 630px;
  		 	top: 300px;
  		 	text-align: center;	
  		}
  		.circle {border-radius: 50%;
			width: 10px;
			height: 10px;
			background-color: white;
			display: block;
   			margin-left: auto;
    		margin-right: auto;	
    		margin-top: 20px;
    		margin-bottom: 10px;
  		}
	    </style>
	<title>Search Error</title>
</head>
<body>	
	<div id="Navigation-bar"></div>

	<script>
		$(function() {
			$("#Navigation-bar").load("NavigationBar.html");
		});
	</script>
	<img src="./Images/maimun.jpg" >
	<div class = "error">
		<div class = "circle"></div>
		<div class = "circle"></div>
		<h4>საუკეთესო მკითხავების მობილიზების მიუხედავად, თქვენ მიერ შეყვანილი მომხმარებელი არ მოიძებნა</h4>
		<form action="Homepage.jsp">
	   		<button class = "btn btn-default">მთავარ გვერდზე დაბრუნება</button>
		</form>		
	</div>
	<script src="ChatRequest.js"></script>
</body>
</html>