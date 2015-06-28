/**
 * 
 */

var ju = setInterval(function(){ checkRequest() }, 5000);

function checkRequest() {
	 $.post("checkChatRequests",
		        {},
		        function(data,status){
		        	if(data.length  == 0 ){
		        		alert("length0");
		        	}
		        	else{
		        		alert("length9");
		        	}
		        	
		        });
}