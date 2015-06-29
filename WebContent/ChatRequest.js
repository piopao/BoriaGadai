/**
 * 
 */

var ju = setInterval(function(){ checkRequest(); }, 2000);

function checkRequest() {
	 $.post("checkChatRequests",
		        {},
		        function(data,status){
		        	if(data.length  != 0 ){
		        		 if (confirm("áƒ£áƒ›áƒ™áƒ˜áƒ—áƒ®áƒ�áƒ•áƒ”áƒ”áƒ‘?") == true) {
		        			 	window.location = "Chat.html";
		        			 	$.post("changeRequestStatus", {}, function(data,status){}
		        		        );
		        		    } else {
		        		        $.post("changeRequestStatus", {}, function(data,status){}
		        		        );
		        		    }
		        	}		        	
		        });
}