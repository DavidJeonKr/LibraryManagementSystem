package com.david.vo;

public class Account {
	private String user_name;
	private String name;
	private String password;

	public Account(String user_name, String name, String password) {
		super();
		this.user_name = user_name;
		this.name = name;
		this.password = password;
	}
	
	public Account(String user_name, String password) {
		this.user_name = user_name;
		this.password = password;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		String result = user_name + " | " + name + " | " + password;
		return result;
	}

}
