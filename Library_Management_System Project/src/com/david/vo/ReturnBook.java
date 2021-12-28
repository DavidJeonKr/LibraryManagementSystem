package com.david.vo;

import java.util.Date;

public class ReturnBook {
	private int book_seq;
	private int user_seq;
	private String bname;
	private String uname;
	private Date dateofissue;
	private Date dateofreturn;
	
	public ReturnBook() {}
	
	public ReturnBook(int book_seq, int user_seq, String bname, String uname, Date dateofissue, Date dateofreturn) {
		super();
		this.book_seq = book_seq;
		this.user_seq = user_seq;
		this.bname = bname;
		this.uname = uname;
		this.dateofissue = dateofissue;
		this.dateofreturn = dateofreturn;
	}
	public ReturnBook(int book_seq, int user_seq, String bname, String uname) {
		super();
		this.book_seq = book_seq;
		this.user_seq = user_seq;
		this.bname = bname;
		this.uname = uname;
	}

	public int getBook_seq() {
		return book_seq;
	}

	public void setBook_seq(int book_seq) {
		this.book_seq = book_seq;
	}

	public int getUser_seq() {
		return user_seq;
	}

	public void setUser_seq(int user_seq) {
		this.user_seq = user_seq;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public Date getDateofissue() {
		return dateofissue;
	}

	public void setDateofissue(Date dateofissue) {
		this.dateofissue = dateofissue;
	}

	public Date getDateofreturn() {
		return dateofreturn;
	}

	public void setDateofreturn(Date dateofreturn) {
		this.dateofreturn = dateofreturn;
	}
	
	
	

}
