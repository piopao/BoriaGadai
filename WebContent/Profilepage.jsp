<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*, authorization.User"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="Profile.css">
<script src="ExternalLogin.js"></script>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta name="google-signin-client_id"
	content="360066525699-udo2lm0hrdvgd8uconqsg9l54dnbgrdh.apps.googleusercontent.com">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<title>Profile</title>
</head>
<body>

	<div id="Navigation-bar"></div>

	<script>
		$(function() {
			$("#Navigation-bar").load("NavigationBar.html");
		});
	</script>
	
	<script type="text/javascript">
	<%
	HttpSession sess = request.getSession();
	String profile = request.getParameter("profile");
	sess.setAttribute("profile", profile);
	%>
	</script>

	<div class="col-sm-3 text-center" id="rightside-info">
		<div>
			<img alt="Profile picture" id="profilePic" src="" >
		</div>
		<p id="underPicName"></p>
		<table class="table table-striped table-hover">
			<tbody>
				<tr>
					<td><a id="messages" href="#" onclick="ftRequest()"></a></td>
					<td style="width: 30%;"><span
						class="glyphicon glyphicon-envelope"></span></td>
				</tr>
				<tr>
					<td><a id="friending" href="#"></a></td>
					<td><span id="friendingLogo" class="glyphicon glyphicon-globe"></span></td>
				</tr>
				<tr>
					<td><a href="#">რეიტინგი</a></td>
					<td><i><span class="glyphicon glyphicon-star"></span></i> <i><span
							class="glyphicon glyphicon-star"></span></i> <i><span
							class="glyphicon glyphicon-star"></span></i> <i><span
							class="glyphicon glyphicon-star"></span></i></td>
				</tr>
				<tr>
					<td><a href="#">მეგობრები</a></td>
					<td><span class="glyphicon glyphicon-user"></span></td>
				</tr>
				<tr>
					<td><a href="#">წინასწარმეტყველებანი</a></td>
					<td><span class="glyphicon glyphicon-user"></span></td>
				</tr>
			</tbody>
		</table>
	</div>

	<div id="personal-info">
		<table>
			<tr>
				<td><h3>პირადი ინფორმაცია</h3></td>
				<td><a id="edit-info-but" href="#" onclick="editInfo()"><span
						class="glyphicon glyphicon-edit"></span> Edit </a></td>
			</tr>
		</table>
	</div>
	<div id="uneditable-info" class="row row-pos"
		style="visibility: hidden;">
		<div id="username-div" class="col-sm-6 info-row" style="visibility: hidden;">
			<label class="col-xs-5 control-label">მომხმარებლის ID:</label>
			<div id="username" class="col-xs-7 controls"></div>
		</div>
		<div id="name-div" class="col-sm-6 info-row" style="visibility: hidden;">
			<label class="col-xs-5 control-label">სახელი:</label>
			<div id="name" class="col-xs-7 controls"></div>
		</div>
		<div id="surname-div" class="col-sm-6 info-row" style="visibility: hidden;">
			<label class="col-xs-5 control-label">გვარი:</label>
			<div id="surname" class="col-xs-7 controls"></div>
		</div>
		<div id="email-div" class="col-sm-6 info-row" style="visibility: hidden;">
			<label class="col-xs-5 control-label">ელ. ფოსტა:</label>
			<div id="email" class="col-xs-7 controls"></div>
		</div>
		<div id="birthdate-div" class="col-sm-6 info-row" style="visibility: hidden;">
			<label class="col-xs-5 control-label">დაბადების თარიღი:</label>
			<div id="birthdate" class="col-xs-7 controls"></div>
		</div>
		<div id="gender-div" class="col-sm-6 info-row" style="visibility: hidden;">
			<label class="col-xs-5 control-label">სქესი:</label>
			<div id="gender" class="col-xs-7 controls"></div>
		</div>
		<div id="info-div" class="col-sm-6 info-row" style="visibility: hidden;">
			<p id="info" class="container"></p>
		</div>
	</div>

	<div id="editable-info" style="visibility: hidden;">
		<div class="row row-pos">
			<div class="col-sm-6 input-row">
				<label class="col-xs-5 control-label">მომხმარებლის ID:</label> <input
					id="edit-username" type="text" class="col-xs-7 controls"></input>
			</div>
			<div class="col-sm-6 input-row">
				<label class="col-xs-5 control-label">სახელი:</label> <input
					id="edit-name" type="text" class="col-xs-7 controls"></input>
			</div>
			<div class="col-sm-6 input-row">
				<label class="col-xs-5 control-label">გვარი:</label> <input
					id="edit-surname" type="text" class="col-xs-7 controls"></input>
			</div>
			<div class="col-sm-6 input-row">
				<label class="col-xs-5 control-label">ელ. ფოსტა:</label>
				<div id="edit-email" class="col-xs-7 controls"></div>
			</div>
			<div class="col-sm-6 input-row">
				<label class="col-xs-5 control-label">პაროლი:</label>
				<button id="edit-password" class="col-xs-7 controls"
					onclick="ChangePassword()">შეცვალე პაროლი</button>
				<input id="passwordOld" class="col-xs-7 controls"
					placeholder="ძველი პაროლი"></input>
				<p id="error1">თქვენს მიერ შეყვანილი პაროლი არ არის სწორი</p>
				<input id="passwordNew" class="col-xs-7 controls"
					placeholder="ახალი პაროლი"></input>
				<p id="error2">თქვენი პაროლი უნდა შედგებოდეს მინიმუმ 4
					სიმბოლოსგან</p>
			</div>
			<div class="col-sm-6 input-row">
				<label class="col-xs-5 control-label">დაბადების თარიღი:</label> <input
					id="edit-birthdate" type="date" class="col-xs-7 controls"></input>
			</div>
			<div class="col-sm-6 input-row">
				<label class="col-xs-5 control-label">სქესი:</label>
				<form class="col-xs-7 controls gender">
					<input id="male" type="radio" name="gender" value="male" checked>მამრობითი
					<br> <input id="female" type="radio" name="gender" value="female">მდედრობითი
				</form>
			</div>
		</div>
		<div class="input-row">
			<input id="edit-info" type="text"></input>
		</div>
		<div class="input-row">
			<a id="updateInfoForm" href="#"></a>
			<button id="infoChange" onclick="SaveChanges()"
					class="btn btn-success btn-lg text-center">შეინახე
					ცვლილებები</button>
		</div>
	</div>

	<script src="checkUser.js"></script>
	<script src="Profile.js"></script>
</body>
</html>

