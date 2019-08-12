package com.myweb.pojo;

public class User {
	private String username;
	private String passwd;
	public String getusername() {
		return username;
	}
	public void setusername(String username) {
		this.username = username;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", passwd=" + passwd + "]";
	}
	
}
