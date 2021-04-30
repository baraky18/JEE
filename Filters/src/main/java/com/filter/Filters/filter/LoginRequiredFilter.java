package com.filter.Filters.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(urlPatterns="/filter/hello")
public class LoginRequiredFilter implements Filter{

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
		System.out.println("URI is: " + httpServletRequest.getRequestURI());
		if("/filter/hello".equalsIgnoreCase(httpServletRequest.getRequestURI())){
			filterChain.doFilter(httpServletRequest, servletResponse);
		}
		else{
			httpServletRequest.getRequestDispatcher("/filter/hi").forward(httpServletRequest, servletResponse);
		}
	}

}
