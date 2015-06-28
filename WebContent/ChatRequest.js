/**
 * 
 */

var ju = setInterval(function(){ checkRequest() }, 5000);

function checkRequest() {
	 $.post("checkChatRequests",
		        {},
		        function(data,status){
		        	if(data.length  != 0 ){
		        		 if (confirm("Press a button!") == true) {
		        			 	window.location = "Chat.html";
		        			 	alert("bochka")
		        			 	$.post("changeRequestStatus", { "status" : 1 }, function(data,status){}
		        		        );
		        		    } else {
		        		        $.post("changeRequestStatus", { "status" : -1 }, function(data,status){}
		        		        );
		        		    }
		        	}		        	
		        });
}