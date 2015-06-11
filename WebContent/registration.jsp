<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Registration</title>
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="RegistrationValidation.js"></script>
</head>
<body>
	
	<p>ელ.ფოსტა: <input type="text" size="25" value="" id = "email" name = "email"></p>
	<button id = "check">შემოწმება</button><p id = tryagain> </p>	
	<button id = "change">ელ.ფოსტის შეცვლა</button>
	<p>პაროლი <input type="text" size="25" value="" class = "restricted" id = "password" name = "password" disabled></p>
	<p id = "warning"></p>
	<button class = "restricted"  onclick = " return validateInfo()" disabled>რეგისტრაცია</button>

</body>
</html>