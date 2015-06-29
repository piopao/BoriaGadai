
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
					 alert("dsa");
					if(data.length != 0){						
					   	var textfield = document.getElementById("message");
					   	var textdiv = document.getElementById("textarea");
					  	var paragraph = document.createElement("p");
					  	var node = document.createTextNode(data);
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





function flip1(_src){
	var tokenedIntoPair =  _src.split("/");
	var length = tokenedIntoPair.length;
	var backsrc = tokenedIntoPair[length-1];
	if(backsrc == "back2.jpg"){
		document.getElementById("1").src="./Images/Decks/tarot deck chat/2.jpg";
	}
	return true;
}

function flip2(_src){
	var tokenedIntoPair =  _src.split("/");
	var length = tokenedIntoPair.length;
	var backsrc = tokenedIntoPair[length-1];
	if(backsrc == "back2.jpg"){
		document.getElementById("2").src="./Images/Decks/tarot deck chat/32.jpg";
	}
	return true;
}

function flip3(_src){
	var tokenedIntoPair =  _src.split("/");
	var length = tokenedIntoPair.length;
	var backsrc = tokenedIntoPair[length-1];
	if(backsrc == "back2.jpg"){
		document.getElementById("3").src="./Images/Decks/tarot deck chat/4.jpg";
	}
	return true;
}


function flip4(_src){
	var tokenedIntoPair =  _src.split("/");
	var length = tokenedIntoPair.length;
	var backsrc = tokenedIntoPair[length-1];
	if(backsrc == "back2.jpg"){
		document.getElementById("4").src="./Images/Decks/tarot deck chat/65.jpg";
	}
	return true;
}






