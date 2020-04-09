<!-- jsp is converted into a servlet by tomcat server. so basically, each code under tag "%" will go into a get method of the generated file -->
<!-- the directive tag "%@" is used to declare things that will be used anywhere in this file (for example import classes-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- we can use directive tag "%@" to call another jsp -->
	<%@include file="/Hello.jsp" %>
	<h3>Hello from JSP</h3>
	<b>The time is: </b><%=new Date() %>
	<!-- the declaration tag "%!" will be available to all of the script tags inside the JSP -->
	<%!
		public int add(int a, int b){
			return a+b;
		}
	%>
	
	<br>
	<!-- the script tag "%" allows us to write java code inside the JSP -->
	<%
		int i = 1;
		int j = 2;
		int k = i + j;
		out.println("The value of k is: " + k);
	%>
	<!-- I can execute html code inside a for loop by closing the "%" tag after the first curly brace and opening another "%" tag before the closing curly brace -->
	<%
		for(int s=0; s<5; s++){
	%>
		<br>
		The value of s is: <%=s %>
	<%
		}
	%>
	<br>
	The value of k is: <%=k %>
	<br>
	Another value is: <%=1+2 %>!!!
	<%
	k=add(2222, 46545);
	%>
	<br>
	Another value of k is: <%=k%>!!!
</body>
</html>