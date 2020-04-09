package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SimpleServlet
 */
@WebServlet(description = "Simple Servlet Description", urlPatterns = { "/SimpleServletPath" },
initParams={@WebInitParam(name="defaultUser", value="John Doe")})//I can insert a predefined value (like default user) to set it on the servlet, no matter from who it's called
public class SimpleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello from Servlet!");
		String userName = request.getParameter("userName");
		HttpSession session = request.getSession();//HttpSession objects lets us save a value on session and access it during multiple calls from same client (for example different browser)
		ServletContext context = request.getServletContext();//ServletContext objects lets us save a value on session and access it during multiple calls from multiple client (for example different browser)
		if (userName != null && !userName.isEmpty()) {
			session.setAttribute("sessionName", userName);
			context.setAttribute("sessionName", userName);
		}
		PrintWriter out = response.getWriter();
		out.println("Request parameter is: " + userName);
		out.println("Request parameter of session is: " + (String)session.getAttribute("sessionName"));
		out.println("Request parameter of context is: " + (String)context.getAttribute("sessionName"));
		out.println("Request parameter of default is: " + (String)this.getServletConfig().getInitParameter("defaultUser"));
	}

}
