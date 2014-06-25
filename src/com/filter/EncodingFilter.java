package com.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EncodingFilter extends HttpServlet implements Filter {
	private String encoding = "GBK";
	private FilterConfig filterConfig;
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		try
		{
			request.setCharacterEncoding(encoding);
			filterChain.doFilter(request, response);                       // 
		}
		catch (ServletException sx)
		{
			filterConfig.getServletContext().log(sx.getMessage(),sx);
		}
		catch (IOException iox)
		{
			filterConfig.getServletContext().log(iox.getMessage());
		}
	}
	public void init(FilterConfig filterConfig) throws ServletException {
		this.encoding = filterConfig.getInitParameter("encoding");
		this.filterConfig = filterConfig;
	}
	public EncodingFilter() {
		super();
	}
	public void destroy() {
		this.encoding = null;
		this.filterConfig = null;
	}
	public void init() throws ServletException {
		// Put your code here
	}
}