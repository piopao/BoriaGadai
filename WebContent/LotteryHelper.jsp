<%@ page import="weather.DBManager"%>
<%
String strResponse;
DBManager db = new DBManager();
strResponse = "" +  db.LotteryAdd(request.getQueryString());
%>
<%=strResponse%>