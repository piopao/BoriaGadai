/**
 * 
 */

var ju = setInterval(function(){ checkRequest() }, 2000);

function checkRequest() {
	 $.post("checkChatRequests",
		        {},
		        function(data,status){
		        	if(data.length  != 0 ){
		        		 if (confirm("უმკითხავეებ?") == true) {
		        			 	window.location = "Chat.html";
		        			 	$.post("changeRequestStatus", { "status" : "1" }, function(data,status){}
		        		        );
		        		    } else {
		        		        $.post("changeRequestStatus", { "status" : "-1" }, function(data,status){}
		        		        );
		        		    }
		        	}		        	
		        });
}