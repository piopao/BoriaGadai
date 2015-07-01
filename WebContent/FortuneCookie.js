function breakCookie1() {
	breakCookie("cookie1");
}

function breakCookie2() {
	breakCookie("cookie2");
}

function breakCookie3() {
	breakCookie("cookie3");
}

function breakCookie4() {
	breakCookie("cookie4");
}

function breakCookie(cookie){
	if(document.getElementById(cookie).getAttribute("disabled") == "true"){
		alert("უკვე ჭამე ნოდარი");
	}else{
		document.getElementById(cookie).src = "./Images/broken-cookie.png";
		document.getElementById(cookie).setAttribute("disabled", "true");
		document.getElementById(cookie).style.cssText = 'height: 120px; margin-top: 80px; width: 160px;';
		getFortune();
	}
}

function getFortune(){
	document.getElementById("AddReview").disabled = false;
	$.get("FortuneCookieServlet", function(data){
		if(data != ""){
			document.getElementById("cookieFortune").style.visibility = "visible";
			document.getElementById("fortune").innerHTML = data;
		}
	});
}

function disappearFortune(){
	document.getElementById("cookieFortune").style.visibility = "hidden";
}
