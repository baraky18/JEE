package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class XmlServlet extends HttpServlet{

	private static final long serialVersionUID = -3497925760066120950L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello from XML GET Servlet!");
		response.setContentType("text/html");
		String userName = request.getParameter("userName");
		PrintWriter out = response.getWriter();
		out.println("<h3>Hello in HTML</h3>");
		out.println(userName);
		out.println(this.getInitParameter("defaultName"));
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello from XML POST Servlet!");
		response.setContentType("text/html");
		String userName = request.getParameter("userName");
		String fullName = request.getParameter("fullName");
		String prof = request.getParameter("prof");
		String gender = request.getParameter("gender");
		String[] locations = request.getParameterValues("location");
		PrintWriter out = response.getWriter();
		out.println("Hello from POST " + userName + "! your full name is: " + fullName);
		out.println("Your profession is " + prof);
		out.println("Your gender is " + gender);
		for(String location: locations){
			out.println("Your location is " + location);
		}
	}
}
