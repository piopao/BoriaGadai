
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
					if(data.length != 0){
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
		        {  },
		        function(data,status){		        	
		        	var textdiv = document.getElementById("textarea");
		        	var paragraph = document.createElement("p");		        	
		        	var node = document.createTextNode(data + ": " + document.getElementById("message").value);
		        	paragraph.appendChild(node);
		        	textdiv.appendChild(paragraph);
		        	$.post("addNewChatMessage", { text: document.getElementById("message").value 
		   		 }, function(data,status){
		   		 });
		   	 document.getElementById("message").value = " "; 
		        	
		        		
	 });	
	 /*$.post("addNewChatMessage", { text: document.getElementById("message").value 
		 }, function(data,status){
		 });
	 document.getElementById("message").value = " ";     */
}





function flip1(_src){
	var tokenedIntoPair =  _src.split("/");
	var length = tokenedIntoPair.length;
	var backsrc = tokenedIntoPair[length-1];
	if(backsrc == "back2.jpg"){
		document.getElementById("1").src="./Images/Decks/tarot deck chat/2.jpg";
	}else{
		document.getElementById("1").src="./Images/Decks/tarot deck chat/back2.jpg";
	}
	return true;
}

function flip2(_src){
	var tokenedIntoPair =  _src.split("/");
	var length = tokenedIntoPair.length;
	var backsrc = tokenedIntoPair[length-1];
	if(backsrc == "back2.jpg"){
		document.getElementById("2").src="./Images/Decks/tarot deck chat/32.jpg";
	}else{
		document.getElementById("2").src="./Images/Decks/tarot deck chat/back2.jpg";
	}
	return true;
}

function flip3(_src){
	var tokenedIntoPair =  _src.split("/");
	var length = tokenedIntoPair.length;
	var backsrc = tokenedIntoPair[length-1];
	if(backsrc == "back2.jpg"){
		document.getElementById("3").src="./Images/Decks/tarot deck chat/4.jpg";
	}else{
		document.getElementById("3").src="./Images/Decks/tarot deck chat/back2.jpg";
	}
	return true;
}


function flip4(_src){
	var tokenedIntoPair =  _src.split("/");
	var length = tokenedIntoPair.length;
	var backsrc = tokenedIntoPair[length-1];
	if(backsrc == "back2.jpg"){
		document.getElementById("4").src="./Images/Decks/tarot deck chat/65.jpg";
	}else{
		document.getElementById("4").src="./Images/Decks/tarot deck chat/back2.jpg";
	}
	return true;
}








