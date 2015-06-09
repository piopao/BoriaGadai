/**
 * 
 */

/*amowmebs shemoyvanili maili carieli tu araa da idzaxebs servletis post metods, sadac mowmdeba sheyvanili maili ukve bazashia tu ara*/
$(document).ready(function(){
    $("#check").click(function(){
    	var email = document.getElementById("email").value;
    	if(!(email.length === 0 || !email.trim())){
	        $.post("CheckRegistrationServlet",
	        {
	          name: document.getElementById("email").value
	        },
	        function(data,status){
	            if(data.length > 0){  
	            	document.getElementById("email").disabled = true;
	            	document.getElementById("check").disabled = true;
	            	var list = document.getElementsByClassName("restricted");
	            	for (var i = 0; i < list.length; i++) {
	            		list[i].disabled = false;
	            	}
	            	document.getElementById("tryagain").innerHTML = "";
	            }
	            else{
	            	var list = document.getElementsByClassName("restricted");
	            	for (var i = 0; i < list.length; i++) {
	            		list[i].disabled = true;
	            	}
	            	document.getElementById("tryagain").innerHTML = "please, try again";
	            }
	        });
    	}       
    });
});


$(document).ready(function(){
    $("#change").click(function(){
    	var disabled = $(document.getElementById("email")).is(':disabled');
    	if(disabled){
    		document.getElementById("email").disabled = false;
        	document.getElementById("check").disabled = false;
        	var list = document.getElementsByClassName("restricted");
        	for (var i = 0; i < list.length; i++) {
        		list[i].disabled = true;
        	}
    	}    	
    });
});
  


function validateInfo(){
	var password = document.getElementById("password").value;	
	if(password.length < 4 || !password.trim()){
		document.getElementById("warning").innerHTML = "The password should be at least 4 symbols long";
		return false;
	}
	else{
		return true;
	}
}