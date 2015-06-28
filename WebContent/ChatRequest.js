/**
 * 
 */

var myVar = setInterval(function(){ checkRequest() }, 1000);

function checkRequest() {
	 $.post("CheckRegistrationServlet",
		        {},
		        function(data,status){
		        	
		        });
}