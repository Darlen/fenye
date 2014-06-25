package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.PageBean;
import com.dao.UserDaoImpl;
import com.orm.User;
import com.pager.Pager_demo;

public class FenYeServlet2 extends HttpServlet { // �����ҳ�� Servlet

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		// ContactBean con;
		try {
			UserDaoImpl con = new UserDaoImpl(); // �����¶���ʱ,�������ݿ�����,��ʼ��һ��
													// ArrayList
			String page = request.getParameter("jumpPage"); // Ϊfoot.jsp�����ֵ

			if (page == null) // �����жϻ��ڵ�һ�ε�½ʱ��ʾ��ҳ,������ beg �ĳ���
				page = "1";
			
			Pager_demo<User> pager = con.listData2(page);
			request.setAttribute("pager", pager);

			request.getRequestDispatcher("/fenye2/main.jsp").forward(request,
					response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
}
