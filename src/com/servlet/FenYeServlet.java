package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.PageBean;
import com.dao.UserDaoImpl;

public class FenYeServlet extends HttpServlet {                        // 处理分页的 Servlet

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	    	response.setContentType("text/html");
			try {				
				UserDaoImpl con = new UserDaoImpl();			 // 生成新对象时,创建数据库连接,初始化一个 ArrayList
				String page = request.getParameter("jumpPage");             // 为page.jsp传入的值
				
				  if(page==null)                                 // 这样判断会在第一次登陆时显示首页,避免了 beg 的出现
					page="1";
				
				PageBean pb = con.listData(page); 			
				request.setAttribute("page",pb);	
				
				request.getRequestDispatcher("/fenye1/main.jsp").forward(request,response);	
			} catch (Exception e) {
				e.printStackTrace();
			}                  
						   			
	     }	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		   this.doPost(request, response);
	}
  }

