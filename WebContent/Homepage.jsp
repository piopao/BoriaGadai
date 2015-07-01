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

<div class = wrapwrap>
  <div class = wrap>
	<div class="container fortune-tellings">
	
		<div class="row">
			<a href="GameDescription.jsp?gameName=lottery&gameLink=Lottery.html">
					<img id=p4 class = predPic src="./Images/lottery-icon.png" onmouseover="onmousePic(this)" onmouseout="outmousePic(this)" >
				</a>
			
				<a class = predLink href="GameDescription.jsp?gameName=fortunecookie&gameLink=FortuneCookie.jsp">
				<img id=p1 class = predPic src="./Images/cookie-icon.png"  onmouseover="onmousePic(this)" onmouseout="outmousePic(this)">
				</a>
				<a class = predLink href="GameDescription.jsp?gameName=weather&gameLink=Weather.html"> 
				 <img id=p2 class = predPic src="./Images/weather-icon.png" onmouseover="onmousePic(this)" onmouseout="outmousePic(this)">
				</a>
				<a class = predLink href="GameDescription.jsp?gameName=yesno&gameLink=YesNo.jsp"> 
				 <img id=p3 class = predPic src="./Images/yesno-icon.png" onmouseover="onmousePic(this)" onmouseout="outmousePic(this)">
				</a>		
		</div>
		<div class = finalRow>
			<a class = predLink href="GameDescription.jsp?gameName=tarot&gameLink=Tarot.html">
				<img  id = tarot class = predPic src="./Images/tarot-icon.png" onmouseover="onmousePic(this)" onmouseout="outmousePic(this)">
			</a>
		</div>
		
	</div>
	</div>
</div>





	<div id=popDiv class="col-xs-1 popularUsers">
		<h1 class="pop-users">ტოპ მკითხავი</h1>
		<table class="table table-hover">
			<tbody>
				<tr id="top1">
					<td id="userRating1"></td>
					<td><a id="topuser1" class=top href="#"></a></td>
				</tr>
				<tr id="top2">
					<td id="userRating2"></td>
					<td><a id="topuser2" class=top href="#"></a></td>
				</tr>
				<tr id="top3">
					<td id="userRating3"></td>
					<td><a id="topuser3" class=top href="#"></a></td>
				</tr>
				<tr id="top4">
					<td id="userRating4"></td>
					<td><a id="topuser4" class=top href="#"></a></td>
				</tr>
				<tr id="top5">
					<td id="userRating5"></td>
					<td><a id="topuser5" class=top href="#"></a></td>
				</tr>
				<tr id="top6">
					<td id="userRating6"></td>
					<td><a id="topuser6" class=top href="#"></a></td>
				</tr>
				<tr id="top7">
					<td id="userRating7"></td>
					<td><a id="topuser7" class=top href="#"></a></td>
				</tr>
				<tr id="top8">
					<td id="userRating8"></td>
					<td><a id="topuser8" class=top href="#"></a></td>
				</tr>
				<tr id="top9">
					<td id="userRating9"></td>
					<td><a id="topuser9" class=top href="#"></a></td>
				</tr>
				<tr id="top10">
					<td id="userRating10"></td>
					<td><a id="topuser10" class=top href="#"></a></td>
				</tr>
				<tr>
					<td><button id=popButton type="button"
							onclick="onmousePopul()">
							<span class="glyphicon glyphicon-chevron-left"></span>დაკლიკე
						</button></td>
				</tr>
			</tbody>
		</table>
	</div>

	<script>
		popUsers();
		function popUsers() {
			$.post('PopularUsers', function(data) {
				if (data != "") {
					alert(data);
					loadUsers(data);
				}
			});
		}

		function loadUsers(data) {
			var dataTokens = data.split("/");
			for (var index = 1; index < dataTokens.length; index++) {
				document.getElementById("topuser" + index).innerHTML = dataTokens[index];
				document.getElementById("topuser" + index).href = "Profilepage.jsp?profile="
						+ dataTokens[index];
				document.getElementById("userRating" + index).innerHTML = dataTokens[++index];
			}

		}
	</script>

		

<script>
$(document).ready(function(){
	 $(".predPic").fadeIn(5000);
});

function onmousePic(x){	
	$(x).animate({width:"250px"},100);
}



function outmousePic(x){
	$(x).animate({width:"140px"},100);
}


function onmousePopul(){
	$("#popDiv").animate({ 
        right: "100px",
      }, 1000 );
	document.getElementById("popButton").onclick = outmousePopul;
}

function outmousePopul(){
	$("#popDiv").animate({ 
        right: "-150px",
      }, 1000 );
	document.getElementById("popButton").onclick = onmousePopul;
}

</script>	
<script src="ChatRequest.js"></script>
<script src="checkUser.js"></script>
</body>
</html>

