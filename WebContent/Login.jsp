<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>	
	<link rel="stylesheet" type="text/css" href="Login.css">
	<meta charset="UTF-8">
	<title>Login</title>	
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
  	<!--   <script src="LoginValidation.js"></script> -->
  	<script>
	  	function validateInfo(){		
			var email = document.getElementById("email").value;
			var password = document.getElementById("password").value;
			
			if(email.length === 0 || !email.trim() || password.length < 4  || !password.trim()){
				document.getElementById("warning").innerHTML = "გადაამოწმეთ ელ.ფოსტა და პაროლი";
				return false;
			}
			else{
				return true;
			}
		}
  	</script>
</head>
<body>
	
	 <div class ="login">
	 	<h2 id = "welcome">შებრძანდით,დაბრძანდით</h2>
		<% 
			HttpSession sess = request.getSession();
			String condition = (String)sess.getAttribute("LoginStatus");			
			if(!(condition == null) && condition.equals("TryAgain")){
				sess.setAttribute("LoginStatus", null);
				out.println("<h3>მომხმარებლის მონაცემები არასწორია, გთხოვთ, გადაამოწმოთ და თავიდან ცადოთ</h3>");
			}
		%>
		<p id = "warning">* *</p>
		<form action="LoginServlet" method="post">
		<div class="form-group">
			 <input placeholder="ელფოსტა" type="text"  class="form-control"  value="" id = "email" name = "email">
		</div>
		<div class="form-group">
			
			<input placeholder="პაროლი" type="password"  class="form-control"  value="" id = "password" name = "password">
			<br>
			<input type="submit" class="btn btn-default" value="შესვლა " onclick = " return validateInfo()">
		</div>
		</form>		
		<p><a href  = "registration.jsp" class = "further" > ახალი მომხმარებლის შექმნა </a></p>
		<p><a href  = "Homepage.jsp"  class = "further"  > სტუმრად შესვლა </a></p>
	</div> 
</body>
</html>