package com;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.User;
import com.service.LoginService;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		LoginService loginService = new LoginService();
		boolean result = loginService.authenticate(userId, password);
		if(result){
			User user = loginService.getUserDetails(userId);
			request.getSession().setAttribute("user", user);//setting the user on the session so it will be available in the jsp that's called
			response.sendRedirect("success.jsp");//this is the way to call another jsp or servlet
			return;
		}
		else{
			//another way to transfer data between jsps or servlets is by request dispatcher
			//that way, we are continuing the same request and don't use the session
			request.setAttribute("message", "User is not authorized!");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
			requestDispatcher.forward(request, response);
			return;
		}
	}

}
