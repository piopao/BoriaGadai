<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="java.util.List" %>
 <%@ page import="game_description.GameDescription" %>
 <%@ page import="Fteller.db.managers.GameManager" %>
 <%@ page import="Fteller.db.managers.UserAccountManager" %>
 <%@ page import="review.Review" %>
 <%@ page import="authorization.User" %>
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
String gameLink = request.getParameter("gameLink");
HttpSession sess = request.getSession();
User user = (User)sess.getAttribute("user");
ServletContext context = getServletContext();
GameManager db = (GameManager)context.getAttribute("GameManager");
GameDescription gd = db.getGameDescription(gameParameter);
UserAccountManager userManager = (UserAccountManager)context.getAttribute("accountManager");
ArrayList<Review> revArr = gd.getReviews();
String printing = "";

//Printing Description
out.println(" <div class=gamePicCover> <div class = gamePic>  <img id=gamePic class = gamePic src=\"./Images/" +gd.getImage() +"\"> </div> </div>");
out.println(" <div class=gameTextCover> <div class = gameText> <h4 class = gameText>" + gd.getDiscription() + "</h4> </div> </div>");
if(user != null) out.println("<a id= \"gameButt\" href= \""+ gameLink +"\" class=\"btn btn-success  btn-lg\" role=\"button\">ვიმკითხაოთ</a>");
else out.println("<a id= \"gameButt\" href= \""+ gameLink +"\" class=\"btn btn-success  btn-lg disabled\" role=\"button\">ვიმკითხაოთ</a>");
printing += "<div class = cover> <div class = reviewComb> ";

//Printing Reviews
if(revArr != null){
for(int i=revArr.size()-1; i>=0; i--){
	Review rev = revArr.get(i);
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
function deleteRev(x){
        $.post("ReviewsServlet",
        {
          mission: "review delete",
          reviewID: x.id,
        },
        function(data,status){
        	location.reload();
        });
};
</script>


</body>
</html>
