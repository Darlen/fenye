package com.db;
import java.sql.*;

import javax.naming.*;
import javax.sql.*;
public class DataBase {
	static Connection con = null;
	 private static String username = "root";
	    private static String pwd = "root";
	    private static String url = "jdbc:mysql://localhost:3306/testweb";
	    private static String driver = "com.mysql.jdbc.Driver";
	public static synchronized Connection getConnection(){
		try {
			
			Class.forName(driver);
			 con = DriverManager.getConnection(url, username,
	                    pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	public static void closeConnection(){
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
