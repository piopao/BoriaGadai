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

<link rel="stylesheet" type="text/css" href="FriendRequest.css">
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
		User user = (User) sess.getAttribute("user");
		ServletContext context = getServletContext();
		UserAccountManager manager = (UserAccountManager) context
				.getAttribute("accountManager");
		ArrayList<String> requests = manager
				.checkPendingFriendRequests(user.getEmail());
		String printing = "";
		String email = "";
		//Printing friend requests
		if (requests != null) {
			for (int i = requests.size() - 1; i >= 0; i--) {
				email = requests.get(i);
				printing += "<div class = requests> ";
				printing += "<div class = box> ";
				printing += "<div class=name ><a class=\"userId\" href="
						+ "\"Profilepage.jsp?profile=" + email + "\">"
						+ email + "</a></div> ";

				printing += "<button ";
				printing += "id=\"accept\" name=\""+email+"\" onclick=\"accRej(this)\" type=\"button\" class=\"btn btn-success btn-xs\">დაამატე </button>";
				printing += "<button ";
				printing += "id=\"reject\" name=\""+email+"\" onclick=\"accRej(this)\" type=\"button\" class=\"btn btn-success btn-xs\">არ დაამატო </button>";
			}
			printing += " </div> "; //box daixura	
		}
		printing += "</div> </div>";

		out.println(printing);
	%>

	<script>
		function accRej(user) {
			$.post("accRejFriendRequest", {
				action : user.id,
				request : user.name,
			}, function(data) {
				location.reload();
			});
		};
	</script>

	<script src="ChatRequest.js"></script>
	<script src="checkUser.js"></script>
</body>
</html>