package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.PageBean;
import com.dao.UserDaoImpl;

public class FenYeServlet extends HttpServlet {                        // �����ҳ�� Servlet

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	    	response.setContentType("text/html");
			try {				
				UserDaoImpl con = new UserDaoImpl();			 // �����¶���ʱ,�������ݿ�����,��ʼ��һ�� ArrayList
				String page = request.getParameter("jumpPage");             // Ϊpage.jsp�����ֵ
				
				  if(page==null)                                 // �����жϻ��ڵ�һ�ε�½ʱ��ʾ��ҳ,������ beg �ĳ���
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

