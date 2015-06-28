
var myVar = setInterval(function(){ myTimer() }, 1000);

function myTimer() {
    var d = new Date();
    var t = d.toLocaleTimeString();
    document.getElementById("demo").innerHTML = t;
}

var dglumc = setInterval(function(){ checkNewMessages() }, 1000);

function checkNewMessages() {
	
}



function sendMessage(){
	 $.post("checkUserServlet",
		        {},
		        function(data,status){
		        	alert("a");
		        	var textfield = document.getElementById("message");
		        	var textdiv = document.getElementById("textarea");
		        	var paragraph = document.createElement("p");
		        	var node = document.createTextNode(data + ": " + textfield.value);
		        	paragraph.appendChild(node);
		        	textdiv.appendChild(paragraph);
		        	return true;       	
	 });	
}