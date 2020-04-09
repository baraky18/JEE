<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- jspInit() method is corresponding to the init() method in servlet -->
	<%!
	//this example shows us that we can set the context object at the initialzation of the jsp object
	public void jspInit(){
		String defaultUser = getServletConfig().getInitParameter("defaultUser");
		ServletContext context = getServletContext();
		context.setAttribute("defaultUser", defaultUser);
	}
	%>
	The default user is: <%=getServletConfig().getInitParameter("defaultUser") %>
	<br>
	The default user from context is: <%=getServletContext().getAttribute("defaultUser") %>
</body>
</html>