package com.kosmo.springapp.basic.resource;

public class UserCommand {
	private String name;
	private String user;
	private String pass;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	@Override
	public String toString() {
		return "[이름=" + name + ", 아이디=" + user + ", 비번=" + pass + "]";
	}
	
	
}
