/**
 * 
 */
var ju = setInterval(function(){ checkRequest() }, 5000);

function checkRequest() {
	alert("f")
	 $.post("CheckRegistrationServlet",
		        {email:"durdom"},
		        function(data,status){
		        	if(data.length  != 0 ){
		        		 if (confirm("Press a button!") == true) {
		        			 	window.location = "Chat.html";
		        			 	$.post("changeRequestStatus", { "status" : 1 }, function(data,status){}
		        		        );
		        		    } else {
		        		        $.post("changeRequestStatus", { "status" : -1 }, function(data,status){}
		        		        );
		        		    }
		        	}		        	
		        });
}