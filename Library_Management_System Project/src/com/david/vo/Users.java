package com.david.vo;

public class Users {
	private int user_seq;
	private String user_name;
	private String user_birth;
	private String user_phone;
	private String user_mail;
	private int user_rent;
	private String user_address;

	
	public Users(int user_seq, String user_name, String user_birth, String user_phone, String user_mail, int user_rent,
			String user_address) {
		super();
		this.user_seq = user_seq;
		this.user_name = user_name;
		this.user_birth = user_birth;
		this.user_phone = user_phone;
		this.user_mail = user_mail;
		this.user_rent = user_rent;
		this.user_address = user_address;
	}
	
	public Users(String user_name, String user_birth, String user_phone, String user_mail,
			String user_address) {
		this.user_name = user_name;
		this.user_birth = user_birth;
		this.user_phone = user_phone;
		this.user_mail = user_mail;
		this.user_address = user_address;
	}
	
	public Users() {
	}

	public int getUser_seq() {
		return user_seq;
	}

	public void setUser_seq(int user_seq) {
		this.user_seq = user_seq;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_birth() {
		return user_birth;
	}

	public void setUser_birth(String user_birth) {
		this.user_birth = user_birth;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public String getUser_mail() {
		return user_mail;
	}

	public void setUser_mail(String user_mail) {
		this.user_mail = user_mail;
	}

	public int getUser_rent() {
		return user_rent;
	}

	public void setUser_rent(int user_rent) {
		this.user_rent = user_rent;
	}

	public String getUser_address() {
		return user_address;
	}

	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}

	@Override
	public String toString() {
		String result = user_seq + " | " + user_name + " | " + user_birth + " | " + user_phone + " | " + user_mail
				+ " | " + user_rent + " | " + user_address;
		return result;
	}

}
