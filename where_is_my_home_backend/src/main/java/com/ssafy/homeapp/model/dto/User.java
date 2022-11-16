package com.ssafy.homeapp.model.dto;

public class User {

	private String userid, password, name;

	public User(String userid, String password, String name) {
		super();
		this.userid = userid;
		this.password = password;
		this.name = name;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
