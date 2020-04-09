<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- there are 3 objects available in jsp (similar to servlet): request, session and application (corresponding to context) 
		 there is another object specific to jsp which is page context that allows to set parameters in any of the other 3 objects -->
	<%
		String userName = request.getParameter("name");
		String attributeFound = "";
		if(userName != null){
			session.setAttribute("sessionUserName", userName);
			application.setAttribute("applicationUserName", userName);
			
			pageContext.setAttribute("pageContextUserName", userName);
			pageContext.setAttribute("applicationUserName", userName, PageContext.APPLICATION_SCOPE);
			pageContext.setAttribute("sessionUserName", userName, PageContext.SESSION_SCOPE);
			pageContext.setAttribute("name", userName, PageContext.REQUEST_SCOPE);
			attributeFound = (String)pageContext.findAttribute("sessionUserName");
		}
	%>
	<br>
	User name in request is: <%=userName %>
	<br>
	User name in session is: <%=session.getAttribute("sessionUserName") %>
	<br>
	User name in application is: <%=application.getAttribute("applicationUserName") %>
	<br>
	User name in page context is: <%=pageContext.getAttribute("pageContextUserName") %>
	<br>
	Attribute found is: <%=attributeFound %>
</body>
</html>