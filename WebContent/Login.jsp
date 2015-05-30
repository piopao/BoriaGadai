<!DOCTYPE html>
<html>
<head>
<meta charset="US-ASCII">
	<title>Login</title>
	<script src="LoginValidation.js"></script>
</head>
<body>
	<% 
	HttpSession sess = request.getSession();
	String condition = (String)sess.getAttribute("LoginStatus");
	if(condition == null){
		out.println("Please, login");
	}
	else if(condition.equals("TryAgain")){
		sess.setAttribute("LoginStatus", null);
		out.println("<h1>Try again!</h1>");
		out.println("Either your username or password is incorrect. Please, Try again");
	}
	%>
	<p id = "warning"></p>
	<form action="LoginServlet" method="post">
	<div align="left">
	<br>
	User Name: <input type="text" size="25" value="" id = "username" name = "username">
	<br><br>
	Password: <input type="text" size="25" value="" id = "password" name = "password">
	<input type="submit" value="Login" onclick = " return validateInfo()">
	</div>
	</form>
	<br>
	<a href  = "" > create new account </a>
	<a href  = "" > continue as a visitor </a>	
</body>
</html>