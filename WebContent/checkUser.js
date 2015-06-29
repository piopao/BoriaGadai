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

window.fbAsyncInit = function() {
	  FB.init({
	    appId      : '967250553331245',
	    cookie     : true,  // enable cookies to allow the server to access 
	                        // the session
	    xfbml      : true,  // parse social plugins on this page
	    version    : 'v2.2' // use version 2.2
	  });
	  
	  
 FB.getLoginStatus(function(response) {
    statusChangeCallback(response);
  });	  

}


function login() {
	if(document.getElementById("logBut").innerHTML == "შესვლა") {
		document.getElementById("myForm").action = "Login.jsp";
	} else {
		$.post("LogoutServlet",
				function(data, status){
					if(data == "gmail"){
						signOut();
					} else if (data == "facebook"){
						FB.Logout();
					}
		});
		document.getElementById("myForm").action = "Homepage.jsp";
	}
}
