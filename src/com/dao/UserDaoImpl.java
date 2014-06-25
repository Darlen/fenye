package com.dao;

import com.bean.PageBean;

import java.util.*;
import java.sql.*;
import com.db.DataBase;
import com.orm.User;
import com.pager.Pager_demo;

public class UserDaoImpl { // 负责业务的Bean，操作数据库，返回结果
	private Connection con;
	private ArrayList data;

	public UserDaoImpl() throws Exception {
		con = DataBase.getConnection();
		data = new ArrayList();
	}

	/**
	 * @return totalRows
	 * @throws Exception
	 */
	public int getTotalRows() throws Exception {
		int totalRows = 0;
		Statement st = con.createStatement();
		String sql = "select count(*) from pm_user";
		ResultSet rs = st.executeQuery(sql);
		while (rs.next()) {
			totalRows = rs.getInt(1);
		}
		return totalRows;
	}

	public PageBean listData(String pageNumber) throws Exception {
		PageBean page = new PageBean(this);
		int pageNum = Integer.parseInt(pageNumber);
		Statement st = con.createStatement();
		// SQL Server的查询语句
		/*
		 * String sql = "select top "+ page.rowsPage
		 * +" * from user where id not in (select top "+ page.rowsPage*(pageNum
		 * - 1) + " * from user order by id) order by id";
		 */
		// MySQL 的查询语句
		String sql = "select * from pm_user limit " + page.rowsPage
				* (pageNum - 1) + "," + page.rowsPage;

		UserDAO userDAO = new UserDAO();
		ArrayList data = userDAO.getData(sql);

		page.currentPage = pageNum;
		page.data = data;

		return page;
	}

	public Pager_demo<User> listData2(String pageNumber) throws Exception {
		Pager_demo<User> pager = new Pager_demo<User>(getTotalRows(),
				Integer.valueOf(pageNumber));
		// PageBean page = new PageBean(this);
		int pageNum = Integer.parseInt(pageNumber);
		Statement st = con.createStatement();
		// SQL Server的查询语句
		/*
		 * String sql = "select top "+ page.rowsPage
		 * +" * from user where id not in (select top "+ page.rowsPage*(pageNum
		 * - 1) + " * from user order by id) order by id";
		 */
		// MySQL 的查询语句
		String sql = "select * from pm_user limit " + pager.getPageCount()
				* (pageNum - 1) + "," + pager.getPageCount();

		UserDAO userDAO = new UserDAO();
		List<User> data = userDAO.getData2(sql);

		pager.setList(data);

		// page.currentPage = pageNum;
		// page.data = data;

		return pager;
	}

	public ArrayList getData() { // return page show data
		return data;
	}
}
