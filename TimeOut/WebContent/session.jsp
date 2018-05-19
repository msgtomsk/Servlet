<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Session</title>
</head>
<body>
<%
   String mail;
   String password;  
%>
<%
  mail=request.getParameter("name");
  password=request.getParameter("pass");
  System.out.println(mail);
  System.out.println(password);
  if(mail== null || password == null){
	  out.println("FILL ALL THE FIELDS");
  }
  else{
	  session=request.getSession(true);
	  session.setAttribute("usr", "user");
	  request.getRequestDispatcher("link.html").forward(request, response);
  }

%>
</body>
</html>