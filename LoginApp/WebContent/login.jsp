<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<form action="login" method="post">
		<br>User ID: <input type="text" name="userId">
		<br>Password: <input type="password" name="password">
		<br><input type="submit">
	</form>
	
	<%
	String message = (String) request.getAttribute("message"); 
	if(message == null){
		message = "";
	}
	%>
	<h3><%=message %></h3>

</body>
</html>