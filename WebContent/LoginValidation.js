/**
 * 
 */

function validateInfo(){
	var username = document.getElementById("username").value;
	var password = document.getElementById("password").value;
	
	if(username.length === 0 || !username.trim() || password.length < 4  || !password.trim()){
		document.getElementById("warning").innerHTML = "Please, enter username and password longer than 3 symbols";
		return false;
	}
	else{
		return true;
	}
}