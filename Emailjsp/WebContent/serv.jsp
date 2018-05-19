<%@page import="org.mainjsp.Mailserv"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%!
	String to;
	String sub;
	String body;
	
%>
<%

	to = request.getParameter("uname");
	sub = request.getParameter("pass");
	body = request.getParameter("body");
	if(to == null || sub == null || body == null || body.isEmpty()|| to.isEmpty() || sub.isEmpty()){
		%>
	<h2>Fill all the fields</h2>	
	<a href = "index.jsp">Try again</a>
	<%
	}
	else{		
		Mailserv.send(to, sub, body);
	}
	
%>
</body>
</html>