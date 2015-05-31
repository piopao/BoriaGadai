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
		<p>User Name: <input type="text" size="25" value="" id = "username" name = "username"></p>
		<p>Password: <input type="text" size="25" value="" id = "password" name = "password"></p>
		<p><input type="submit" value="Login" onclick = " return validateInfo()"></p>
	</div>
	</form>
	<br>
	<p><a href  = "" > create new account </a></p>
	<p><a href  = "" > continue as a visitor </a></p>
</body>
</html>