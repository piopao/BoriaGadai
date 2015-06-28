
var myVar = setInterval(function(){ myTimer() }, 1000);

function myTimer() {
    var d = new Date();
    var t = d.toLocaleTimeString();
    document.getElementById("demo").innerHTML = t;
}

//var ch = setInterval(function(){ checkMes() }, 2000);

function checkMes(){
		 $.post("checkMessagesServlet",
				 { },			        
			      function(data,status){
					if(data!=null){
					   	var textfield = document.getElementById("message");
					   	var textdiv = document.getElementById("textarea");
					  	var paragraph = document.createElement("p");
					  	var node = document.createTextNode(data + ": " + textfield.value);
					   	paragraph.appendChild(node);
					   	textdiv.appendChild(paragraph);
				   	}
				   	return true;  			        	      	
		 });	
}


$(document).keypress(function(e) {
    if(e.which == 13) {
        sendMessage();
    }
});	

window.setInterval(function() {
	  var elem = document.getElementById('textarea');
	  elem.scrollTop = elem.scrollHeight;
	}, 1000);

function sendMessage(){
	 $.post("CurrentUserServlet",
		        { },
		        function(data,status){
		        	var textfield = document.getElementById("message");
		        	var textdiv = document.getElementById("textarea");
		        	var paragraph = document.createElement("p");
		        	var node = document.createTextNode(data + ": " + textfield.value);
		        	paragraph.appendChild(node);
		        	textdiv.appendChild(paragraph);
		        	document.getElementById("message").value = " ";
		        	return true;       	
	 });	
}













