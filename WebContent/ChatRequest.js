/**
 * 
 */

var myVar = setInterval(function(){ checkRequest() }, 8000);

function checkRequest() {
	 $.post("CheckRegistrationServlet",
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