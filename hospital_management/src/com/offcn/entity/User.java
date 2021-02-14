package com.offcn.entity;

import java.util.Date;

import com.sun.org.apache.xml.internal.security.keys.keyresolver.implementations.PrivateKeyResolver;

public class User {

	private int id;
	private String username;
	private String pwd;
	private String uname;
	private String email;
	private Date cDate;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id, String username, String pwd, String uname, String email, Date cDate) {
		super();
		this.id = id;
		this.username = username;
		this.pwd = pwd;
		this.uname = uname;
		this.email = email;
		this.cDate = cDate;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", pwd=" + pwd + ", uname=" + uname + ", email=" + email
				+ ", cDate=" + cDate + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getcDate() {
		return cDate;
	}
	public void setcDate(Date cDate) {
		this.cDate = cDate;
	}
	
}
