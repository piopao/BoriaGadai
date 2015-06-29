var myVar = setInterval(function(){ myTimer() }, 1000);

function myTimer() {
	var email1 = document.getElementById("user").innerHTML;
	var email2 = document.getElementById("email").innerHTML;
	if (email1 == email2){
		 $.post("CheckPendingRequests", function(data){
			 if(data == "true"){
				 document.getElementById("friendingLogo").className  = "glyphicon glyphicon-flag";
			 }
		 });
	}
}

$(document).ready(function() {
	$.post('UserProfileServlet', function(data) {
		loadInfo(data);
		guestOrUser();
	});
});

function loadInfo(data) {
	var dataTokens = data.split("/");
	for (var index = 0; index < dataTokens.length; index++) {
		if (dataTokens[index] == "profilePic") {
			var pic = "./avatars/" + dataTokens[++index];
			document.getElementById("profilePic").src = pic;
		} else if(dataTokens[index] == "email"){
			document.getElementById(dataTokens[index] + "-div").style.visibility = 'visible';
			document.getElementById("email").innerHTML = dataTokens[++index];
			document.getElementById("underPicName").innerHTML = dataTokens[index];
			
		}else{
			document.getElementById(dataTokens[index] + "-div").style.visibility = 'visible';
			document.getElementById(dataTokens[index]).innerHTML = dataTokens[++index];
		}
	}
}

function guestOrUser() {
	var user = document.getElementById("user").innerHTML;
	var profileUser = document.getElementById("email").innerHTML;
	if (user == profileUser) {
		userRightSideInfo();
	} else if (user == "ადმინი") {
		if (friend() == true) {
			friendRightSideInfo();
		} else {
			guestRightSideInfo();
		}
	} else if (user == "სტუმარი") {
		guestRightSideInfo();
	} else {
		if (true) {
			friendRightSideInfo();
		} else {
			guestRightSideInfo();
		}
	}
}

function userRightSideInfo() {
	document.getElementById("edit-info-but").style.visibility = "visible";
	document.getElementById("edit-info-but").setAttribute("disabled", "false");
	document.getElementById("messages").innerHTML = "მკითხაობის მოთხოვნები";
	document.getElementById("messages").href = "#";
	document.getElementById("friending").innerHTML = "დამეგობრების მოთხოვნები";
	document.getElementById("friending").href = "#";
}

function visitorRightSideInfo() {
	document.getElementById("edit-info-but").style.visibility = "hidden";
	document.getElementById("edit-info-but").setAttribute("disabled", "true");
	document.getElementById("messages").innerHTML = "მიმკითხავე";
	document.getElementById("messages").setAttribute("disabled", "true");
	document.getElementById("friending").innerHTML = "დამეგობრების მოთხოვნა";
	document.getElementById("friending").setAttribute("disabled", "true");
}

function guestRightSideInfo() {
	document.getElementById("edit-info-but").style.visibility = "hidden";
	document.getElementById("edit-info-but").setAttribute("disabled", "true");
	document.getElementById("messages").innerHTML = "მიმკითხავე";
	document.getElementById("messages").setAttribute("disabled", "false");
	document.getElementById("messages").href = "#";
	document.getElementById("friending").innerHTML = "დამეგობრება";
	document.getElementById("friending").setAttribute("disabled", "false");
}

function friendRightSideInfo() {
	document.getElementById("edit-info-but").style.visibility = "hidden";
	document.getElementById("edit-info-but").setAttribute("disabled", "true");
	document.getElementById("messages").innerHTML = "მიმკითხავე";
	document.getElementById("messages").setAttribute("disabled", "false");
	document.getElementById("messages").href = "#";
	document.getElementById("friending").innerHTML = "განმეგობრება";
	document.getElementById("friending").setAttribute("disabled", "false");
}

function editInfo() {
	if (document.getElementById("edit-info-but").getAttribute("disabled") == "false") {
		hideShowInfo();
	}
}

function hideShowInfo() {
	document.getElementById("editable-info").style.visibility = "visible";
	document.getElementById("uneditable-info").style.visibility = "hidden";
	document.getElementById("edit-username").value = document.getElementById("username").innerHTML;
	document.getElementById("edit-name").value = document.getElementById("name").innerHTML;
	document.getElementById("edit-surname").value = document.getElementById("surname").innerHTML;
	document.getElementById("edit-email").innerHTML = document.getElementById("email").innerHTML;
	document.getElementById("edit-info").value = document.getElementById("info").innerHTML;
	document.getElementById("edit-birthdate").value = document.getElementById("birthdate").innerHTML;
	var list = document.getElementsByClassName("info-row");
	for (var i = 0; i < list.length; i++) {
		list[i].style.visibility = "hidden";
	}
}

function ChangePassword(){
	document.getElementById("edit-password").setAttribute("clicked", "true");
	document.getElementById("edit-password").style.visibility = "hidden";
	document.getElementById("passwordOld").style.visibility = "visible";
	document.getElementById("passwordNew").style.visibility = "visible";
}

function SaveChanges() {
	var editUsername = document.getElementById("edit-username").value;
	var editName = document.getElementById("edit-name").value;
	var editSurname = document.getElementById("edit-surname").value;
	if(document.getElementById("edit-password").getAttribute("clicked") == "true"){
		document.getElementById("edit-password").setAttribute("clicked", "false");
		var editPasswordOld = document.getElementById("passwordOld").value;
		var editPasswordNew = document.getElementById("passwordNew").value;
	}else{
		var editPasswordOld = "";
		var editPasswordNew = "";
	}
	var editBirthdate = document.getElementById("edit-birthdate").value;
	if (document.getElementById('male').checked) {
		var editGender = "Male";
	} else {
		var editGender = "Female";
	}
	var editInfo = document.getElementById("edit-info").value;

	$.post('UpdateInfo', {
		username : editUsername,
		name : editName,
		surname : editSurname,
		passwordOld : editPasswordOld,
		passwordNew : editPasswordNew,
		birthdate : editBirthdate,
		gender : editGender,
		info : editInfo
	}, function(data) {
		if(data == "shortPass"){
			document.getElementById("error2").style.visibility = "visible";
		}if(data == "invalidPass"){
			document.getElementById("error1").style.visibility = "visible";
		}else{
			var user = document.getElementById("user").innerHTML;
			var action = "Profilepage.jsp?profile=" + user;
			document.getElementById("updateInfoForm").href = action;
			document.getElementById("updateInfoForm").click();
		}
	});
}

function ftRequest(){
	var buttonEnabled = document.getElementById("messages").getAttribute("disabled");
	if (buttonEnabled == "false"){
		var email1 = document.getElementById("user").innerHTML;
		var email2 = document.getElementById("email").innerHTML;
		$.post("sendChatRequest", {
			sender : email1,
			getter : email2
		}, function(data){
			if (data == "true"){
				alert("მოთხოვნა გაგზავნილია");
				window.location = "Chat.jsp?chatter="+email2;
			}else{
				alert("მოთხოვნა უკვე გაგზავნილია");
			}
		});
	}
}

function fRequest(){
	var buttonEnabled = document.getElementById("friending").getAttribute("disabled");
	var buttonText = document.getElementById("friending").innerHTML;
	if(buttonEnabled == "true"){
		if(buttonText == "დამეგობრება"){
			$.post("sendFriendRequest", {
				sender : email1,
				getter : email2,
				action : buttonText
			}, function(data){
				if (data == "true"){
					alert("მოთხოვნა გაგზავნილია");
				}else{
					alert("მოთხოვნა უკვე გაგზავნილია");
				}
			});
		} else if (buttonText == "განმეგობრება"){
			$.post("sendFriendRequest", {
				sender : email1,
				getter : email2,
				action : buttonText
			}, function(data){
				if (data == "true"){
					alert("მოთხოვნა გაგზავნილია");
					document.getElementById("friending").innerHTML = "დამეგობრება";
				}
			});
		}
	}
}