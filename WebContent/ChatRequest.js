/**
 * 
 */

var ju = setInterval(function(){ checkRequest(); }, 2000);

function checkRequest() {
	 $.post("checkChatRequests",
		        {},
		        function(data,status){
		        	if(data.length  != 0 ){
		        		 if (confirm("უმკითხავებ?") == true) {
		        			 	window.location = "Chat.jsp?chatter=" +data;
		        			 	$.post("changeRequestStatus", {}, function(data,status){}
		        		        );
		        		    } else {
		        		        $.post("changeRequestStatus", {}, function(data,status){}
		        		        );
		        		    }
		        	}		        	
		        });
}