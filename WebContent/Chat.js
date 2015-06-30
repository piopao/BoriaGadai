
var myVar = setInterval(function(){ myTimer() }, 1000);

function myTimer() {
    var d = new Date();
    var t = d.toLocaleTimeString();
    document.getElementById("clock").innerHTML = t;
}

var ch = setInterval(function(){ checkMes() }, 1000);

function checkMes(){
		 $.post("checkMessagesServlet",
				 { },			        
			      function(data,status){
					if(data  && data != "null" && data.length != 0){
						alert(data);
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
}

/*	*/

function flip1(_src){
	var tokenedIntoPair =  _src.split("/");
	var length = tokenedIntoPair.length;
	var backsrc = tokenedIntoPair[length-1];
	
	if(backsrc == "back2.jpg"){
		var src2 = document.getElementById("2").src;
		var tokens2 = src2.split("/");
		var src2card = tokens2[tokens2.length - 1];
		
		var src3 = document.getElementById("3").src;
		var tokens3 = src3.split("/");
		var src3card = tokens3[tokens3.length - 1];
		
		var src4 = document.getElementById("4").src;
		var tokens4 = src4.split("/");
		var src4card = tokens4[tokens4.length - 1];
		
		$.post("GenerateCardServlet", { 
			card1 : src2card,
			card2 : src3card,
			card3 : src4card
			}, function(data,status){
		       document.getElementById("1").src="./Images/Decks/tarot deck chat/"+data;
		       $.post("sendTarotServlet", { card: "1 "+data}, function(data,status){});
		    }
		);		
	}else{		
		document.getElementById("1").src="./Images/Decks/tarot deck chat/back2.jpg";
		 $.post("sendTarotServlet", { card: "1 back2.jpg"}, function(data,status){});
	}
	return true;
}

function flip2(_src){
	var tokenedIntoPair =  _src.split("/");
	var length = tokenedIntoPair.length;
	var backsrc = tokenedIntoPair[length-1];	
	
	if(backsrc == "back2.jpg"){
		var src1 = document.getElementById("1").src;
		var tokens1 = src1.split("/");
		var src1card = tokens1[tokens1.length - 1];
		
		var src3 = document.getElementById("3").src;
		var tokens3 = src3.split("/");
		var src3card = tokens3[tokens3.length - 1];
		
		var src4 = document.getElementById("4").src;
		var tokens4 = src4.split("/");
		var src4card = tokens4[tokens4.length - 1];
		$.post("GenerateCardServlet", { 
			card1 : src1card,
			card2 : src3card,
			card3 : src4card
			}, function(data,status){
		       document.getElementById("2").src="./Images/Decks/tarot deck chat/"+data;
		       $.post("sendTarotServlet", { card: "2 "+data}, function(data,status){});
		    }
		);	
	}else{		
		document.getElementById("2").src="./Images/Decks/tarot deck chat/back2.jpg";
		$.post("sendTarotServlet", { card: "2 back2.jpg"}, function(data,status){});
	}
	return true;
}

function flip3(_src){
	var tokenedIntoPair =  _src.split("/");
	var length = tokenedIntoPair.length;
	var backsrc = tokenedIntoPair[length-1];
	
	if(backsrc == "back2.jpg"){
		var src1 = document.getElementById("1").src;
		var tokens1 = src1.split("/");
		var src1card = tokens1[tokens1.length - 1];
		
		var src2 = document.getElementById("2").src;
		var tokens2 = src2.split("/");
		var src2card = tokens2[tokens2.length - 1];	
		
		var src4 = document.getElementById("4").src;
		var tokens4 = src4.split("/");
		var src4card = tokens4[tokens4.length - 1];
		$.post("GenerateCardServlet", { 
			card1 : src2card,
			card2 : src1card,
			card3 : src4card
			}, function(data,status){
		       document.getElementById("3").src="./Images/Decks/tarot deck chat/"+data;
		       $.post("sendTarotServlet", { card: "3 "+data}, function(data,status){});
		    }
		);	
		
	}else{		
		document.getElementById("3").src="./Images/Decks/tarot deck chat/back2.jpg";
		$.post("sendTarotServlet", { card: "3 back2.jpg"}, function(data,status){});
	}
	return true;
}


function flip4(_src){
	var tokenedIntoPair =  _src.split("/");
	var length = tokenedIntoPair.length;
	var backsrc = tokenedIntoPair[length-1];
	
	if(backsrc == "back2.jpg"){
		var src1 = document.getElementById("1").src;
		var tokens1 = src1.split("/");
		var src1card = tokens1[tokens1.length - 1];
		
		var src2 = document.getElementById("2").src;
		var tokens2 = src2.split("/");
		var src2card = tokens2[tokens2.length - 1];
		
		var src3 = document.getElementById("3").src;
		var tokens3 = src3.split("/");
		var src3card = tokens3[tokens3.length - 1];
		
		$.post("GenerateCardServlet", { 
			card1 : src2card,
			card2 : src3card,
			card3 : src1card
			}, function(data,status){
		       document.getElementById("4").src="./Images/Decks/tarot deck chat/"+data;
		       $.post("sendTarotServlet", { card: "4 "+data}, function(data,status){});
		    }
		);	
	}else{		
		document.getElementById("4").src="./Images/Decks/tarot deck chat/back2.jpg";
		$.post("sendTarotServlet", { card: "3 back2.jpg"}, function(data,status){});
	}
	return true;
}




var chTarot = setInterval(function(){ checkTarot() }, 1000);

function checkTarot(){
	
	$.post("checkTarotServlet", { 
		
		}, 
		function(data,status){
			if(data  && data != "null" || data.length != 0){
				var tokens = data.split(" ");
				 document.getElementById(tokens[0]).src = "./Images/Decks/tarot deck chat/" + tokens[1];
				}
	       
	    	});	
	}
	

	


