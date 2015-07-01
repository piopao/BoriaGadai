<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*, authorization.User"%>
<%@ page import="java.util.List"%>
<%@ page import="game_description.GameDescription"%>
<%@ page import="Fteller.db.managers.GameManager"%>
<%@ page import="Fteller.db.managers.UserAccountManager"%>
<%@ page import="review.Review"%>
<%@ page import="authorization.User"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

<link rel="stylesheet" type="text/css" href="FortuneTellings.css">
<link rel="stylesheet" type="text/css" href="NavigationBar.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<title>Friend Requests</title>
</head>
<body>

	<div id="Navigation-bar"></div>

	<script>
		$(function() {
			$("#Navigation-bar").load("NavigationBar.html");
		});
	</script>


	<%
		HttpSession sess = request.getSession();
		ServletContext context = getServletContext();
		UserAccountManager accountManager = (UserAccountManager) context.getAttribute("accountManager");
		GameManager gameManager = (GameManager)context.getAttribute("GameManager");
		String email = request.getParameter("profile");
		User user = (User) accountManager.getUserAccount(email);
		
		String weather = gameManager.checkTodaysWeather(user);
		String fortuneCookie = gameManager.getCookie(user);
			//	String tarot = gameManager.
		String Lottery = gameManager.getLuckyNumbers(user);
		
		ArrayList<Review> reviews = accountManager.getUserReviews(email);
			
		String printing = "";
		//Printing Reviews
		if(reviews != null){
		for(int i=reviews.size()-1; i>=0; i--){
			Review rev = reviews.get(i);
			printing+= "<div class = review> ";
			printing+= "<div class = box> ";
			printing+= "<div class=name ><a class=\"userId\" href="+ "\"Profilepage.jsp?profile=" + rev.getUser() +"\">" + rev.getUser() + "</a></div> ";
			int stars = rev.getStars();
			printing += "<div class = stars> ";
			for(int k=0; k<stars; k++){
		printing+= "<img src=\"./Images/star-full.png\" > ";
			}	
			for(int z = 0; z<5 - stars; z++){
		printing+= "<img src=\"./Images/star-empty.png\" > ";	}	
			printing+= " </div>"; //stars daixura
			printing+= "<h5 class = date> " + rev.getDate() + "</h5>"; 	
			printing+= "<h5 class = date> " + rev.getGameName() + "</h5>"; 	
			if(user != null){
			printing+= "<button "; 
			if(user.getUserStatus() != 1) printing+= " style = \"display:none;\" ";
			printing+= "id=" + rev.getRevID() +" onclick=\"deleteRev(this)\" type=\"button\" class=\"btn btn-success btn-xs\">წაშალე კომენტარი </button>";
			}
			printing+= " </div> "; //box daixura	
			printing+= "<div class = textbox> <p class = revText>" + rev.getText() + "</p>	 </div>";	
			printing+= " </div>";//review daixura
		}
		printing+= "</div> </div>";
		}
		out.println(printing);
	%>

	<script>
		function deleteRev(x) {
			$.post("ReviewsServlet", {
				"mission" : "review delete",
				"reviewID" : x.id,
			}, function(data, status) {
				location.reload();
			});
		};
	</script>

	<script src="ChatRequest.js"></script>
	<script src="checkUser.js"></script>
</body>
</html>