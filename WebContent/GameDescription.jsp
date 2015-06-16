<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="java.util.List" %>
 <%@ page import="game_discription.GameDiscription" %>
 <%@ page import="game_discription.DBManager" %>
 <%@ page import="review.Review" %>
 <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
  
<link rel="stylesheet" type="text/css" href="GameDescription.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reviews</title>
</head>
<% 
String gameParameter = request.getParameter("gameName");
DBManager db = new DBManager();
GameDiscription gd = db.getGameDiscription(gameParameter);
ArrayList<Review> revArr = gd.getReviews();
String printing = "";
out.println("<h1 class = gameName>" + gd.getGameName() + "</h1>");
out.println(" <div class=gameTextCover> <div class = gameText> <h4 class = gameText>" + gd.getDiscription() + "</h4> </div> </div>");
out.println("<a id= \"gameButt\" href= \""+ gd.getGameLink() +"\" class=\"btn btn-success  btn-lg\" role=\"button\">ვიმკითხაოთ</a>");
printing += "<div class = cover> <div class = reviewComb> ";
for(int i=0; i<revArr.size(); i++){
	Review rev = revArr.get(i);
	printing+= "<div class = review> ";
	printing+= "<div class = box> ";
	printing+= "<div class=name ><a class=\"userId\" href="+ "\"Temp.html?userId=" + rev.getUserId() +"\">" + rev.getUserFullName() + "</a></div> ";
	int stars = rev.getStars();
	printing += "<div class = stars> ";
	for(int k=0; k<stars; k++){
		printing+= "<img src=\"./Images/star-full.png\" > ";
	}	
	for(int z = 0; z<5 - stars; z++){
		printing+= "<img src=\"./Images/star-empty.png\" > ";	}	
	printing+= " </div>"; //stars daixura
	printing+= "<h5 class = date> " + rev.getDate() + "</h5>"; 	
	printing+= " </div> "; //box daixura	
	printing+= "<div class = textbox> <p class = revText>" + rev.getReviewText() + "</p>	 </div>";	
	printing+= " </div>";//review daixura
}
printing+= "</div> </div>";
out.println(printing); 
%>



</body>
</html>