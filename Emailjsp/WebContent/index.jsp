<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<link rel = "stylesheet" href = "css/bootstrap.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mail</title>
</head>

<body class = "container">
<form action = "serv.jsp" method = "get" style= " width:450px;align = center">
	<br/>
	<br/>
	<br/>
  <div class="form-group" >
    <label for="exampleInputEmail1">To</label>
    <input  type="email" class="form-control" name = "uname" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
    
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Subject</label>
    <input type="text" class="form-control" name = "pass" id="exampleInputPassword1" placeholder="subject">
  </div>
  <div class="form-group">
    <label for="exampleFormControlTextarea1">Body</label>
    <textarea class="form-control" name = "body" id="exampleFormControlTextarea1" rows="3" placeholder="body"></textarea>
  </div>
  
  <button type="submit" class="btn btn-primary">Send</button>
  
</form>

</body>
</html>