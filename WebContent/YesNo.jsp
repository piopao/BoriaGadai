<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
	  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	  	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="YesNo.css">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Ask</title>
	<script> function generate(){
		var question = document.getElementById("question").value;
		var today = new Date();
		var dd = today.getDate();
		var s1 = "კი!";
		var s2 = "ნტ, არა";
		if(dd%2 ==0) { s1 = "ნტ, არა"; s2 = "კი!"}
		if(question.length != 0){
			if(question.length % 2 == 0){
				document.getElementById("answer1").innerHTML = s1;
				document.getElementById("answer2").innerHTML = s1;
				document.getElementById("answer3").innerHTML = s1;
			}else{
				document.getElementById("answer1").innerHTML = s2;
				document.getElementById("answer2").innerHTML = s2;
				document.getElementById("answer3").innerHTML = s2;				
			}}
		return true; }
	
	$(document).keypress(function(e) {
	    if(e.which == 13) {
	        generate();
	    }
	});	

	</script>
</head>
<body>
	<div class = "yvelaferi">
		<div class = "chy"></div>
		<div class = "chy"></div>
		<div class = "chy"></div>
		<div class = "chy"></div>
	</div>		 
	<input class="form-control" id="question" type="text">
	<div class = "ragaca"></div>
	<input class="form-control" id="inp" type="button" value = "ოთხი მრგვალი კვადრატის წინასწარმეტყველება: კი თუ არა?" onclick = "return generate()">
	<p class = "answer" id = "answer1"></p>
	<p class = "answer"  id = "answer2"></p>
	<p class = "answer"  id = "answer3"></p>
	
	
<div class =  scroll>
 <img id = scroll onclick = "scrollDownWindow()" class = scroll src="./Images/scroll-down.png">
</div>

<div id = reviewCover class= reviewCover >
</div>

<script> 
 $(function(){
   $("#reviewCover").load("AddReview.html"); 
});
</script>
</body>
</html>