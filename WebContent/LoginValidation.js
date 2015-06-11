/**
 * 
 */

function validateInfo(){
	var email = document.getElementById("email").value;
	var password = document.getElementById("password").value;
	
	if(email.length === 0 || !email.trim() || password.length < 4  || !password.trim()){
		document.getElementById("warning").innerHTML = "გთხოვთ, შეიყვანოთ მომხმარებლის ელ.ფოსტა და მინიმუმ 4 სიმბოლოს შემცველი პაროლი";
		return false;
	}
	else{
		return true;
	}
}