package com.dao;
import com.orm.User;
import com.db.DataBase;

import java.sql.*;
import java.util.*;

public class UserDAO{
	public ArrayList getData(String sql){
		ArrayList data = new ArrayList();							// here List may change ArrayList or Vector
    	
    	Connection con = null;
    	Statement st = null;
    	ResultSet rs = null;
    	try{
    		con = DataBase.getConnection();
    		st = con.createStatement();
    		rs = st.executeQuery(sql);
    		
    		while(rs.next()){
    		  User user = new User();      		  
    		  user.setId(rs.getInt(1));
    		  user.setUserName(rs.getString(2));
//    		  user.setPassword(rs.getString(3));
//    		  user.setBalance(rs.getLong(4));
    		  
    		  data.add(user);     
    		}
    	}catch(Exception e){
    		e.printStackTrace();
    	}finally{                                             
    		DataBase.closeConnection();
    	}
    	return data;
	}
	
	public List<User> getData2(String sql){
		List<User> data = new ArrayList<User>();							// here List may change ArrayList or Vector
    	
    	Connection con = null;
    	Statement st = null;
    	ResultSet rs = null;
    	try{
    		con = DataBase.getConnection();
    		st = con.createStatement();
    		rs = st.executeQuery(sql);
    		
    		while(rs.next()){
    		  User user = new User();      		  
    		  user.setId(rs.getInt(1));
    		  user.setUserName(rs.getString(2));
    		  user.setPassword(rs.getString(3));
//    		  user.setBalance(rs.getLong(4));
    		  
    		  data.add(user);     
    		}
    	}catch(Exception e){
    		e.printStackTrace();
    	}finally{                                             
    		DataBase.closeConnection();
    	}
    	return data;
	}
}