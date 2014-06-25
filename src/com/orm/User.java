package com.orm;
import java.util.*;

public class User  implements java.io.Serializable {
    private int id;									// foretime is Integer
    private String userName;
    private String password;
//    private long balance;
//    private Set mobiles = new HashSet();			// one to many : 这里要有一个集合属性，来存放它所包含的对象
    public User() {
    }
    public User(int id,String userName, String password,long balance) {
    	this.id = id;
        this.userName = userName;
        this.password = password;
//        this.mobiles = mobiles;
    }
    public int getId() {
        return this.id;
    }    
    public void setId(int id) {
        this.id = id;
    }
    public String getUserName() {
        return this.userName;
    }    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return this.password;
    }    
    public void setPassword(String password) {
        this.password = password;
    }
//    public Set getMobiles(){
//    	return mobiles;
//    }
//    public void setMobiles(Set mobiles){
//    	this.mobiles = mobiles;
//    }
//    public long getBalance(){
//    	return balance;
//    }
//    public void setBalance(long balance){
//    	this.balance = balance;
//    }
  }
