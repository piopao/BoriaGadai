<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>მკითხაობა</title>
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="Chat.css">
	<script src="Chat.js"></script>	
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
	<% HttpSession sess = request.getSession();
	String chatter = request.getParameter("chatter");
	sess.setAttribute("chatter", chatter);
	System.out.println("stat");
	System.out.println(request.getParameter("status"));
	%>
	<div class="container">
        <div class="row">
                <div class="col-md-6">
                        <div class = "chat">
                                <div class = "outer"><img id = "teller" src="./Images/mo.gif" onclick = "return sendMessage()" ></div> 
                                <div class =  "textarea" id = "textarea">
                                       
                                </div>
                                <input class="form-control" type="text" size="15" value="" id = "message" name = "message">    
                </div>         
        </div>
        <div class="col-md-6">
        	 <p id="clock"></p>
        	<div id ="cards">
        		<% 
					String stat = request.getParameter("status");
        			if(stat != null && stat.equals("teller")){
	        			out.println("<div><img id = \"1\" src=\"./Images/Decks/tarot deck chat/back2.jpg\" onclick = \"return flip1(this.src)\">");
	        			out.println("<img id = \"2\" src=\"./Images/Decks/tarot deck chat/back2.jpg\" onclick = \"return flip2(this.src)\">");
	        			out.println("<div><img id = \"3\" src=\"./Images/Decks/tarot deck chat/back2.jpg\" onclick = \"return flip3(this.src)\">");
	        			out.println("<img id = \"4\" src=\"./Images/Decks/tarot deck chat/back2.jpg\" onclick = \"return flip4(this.src)\">");
        			} else{
        				out.println("<div><img id = \"1\" src=\"./Images/Decks/tarot deck chat/back2.jpg\">");
	        			out.println("<img id = \"2\" src=\"./Images/Decks/tarot deck chat/back2.jpg\">");
	        			out.println("<div><img id = \"3\" src=\"./Images/Decks/tarot deck chat/back2.jpg\">");
	        			out.println("<img id = \"4\" src=\"./Images/Decks/tarot deck chat/back2.jpg\">");
        			}
				%>     	
        	</div>       
        </div>                       
  </div>
</div>
</body>
</html>