//
$(document).ready(function() {
	$.post('CheckUserServlet', function(data) {
		if (data == "სტუმარი") {
			document.getElementById("logBut").innerHTML = "შესვლა";
			document.getElementById("user").innerHTML = data;
		} else if (data == "ადმინი") {
			document.getElementById("user").innerHTML = data;
		} else {
			document.getElementById("user").innerHTML = data;
			document.getElementById("user").href = "Profilepage.jsp?email=" + data;
			document.getElementById("logBut").innerHTML = "გამოსვლა";
		}
	});
});

function login() {
	if(document.getElementById("logBut").innerHTML == "შესვლა") {
		document.getElementById("myForm").action = "Login.jsp";
	} else {
		$.post("LogoutServlet",
				function(data, status){
					if(data == "gmail"){
						signOut();
					} else if (data == "facebook"){
						FB.logout();
					}
		});
		document.getElementById("myForm").action = "Homepage.jsp";
	}
}