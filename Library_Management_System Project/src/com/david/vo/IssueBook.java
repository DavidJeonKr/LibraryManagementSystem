package com.david.vo;

import java.util.Date;

public class IssueBook {
	private String book_seq;
	private String user_seq;
	private String bname;
	private String uname;
	private Date dateofissue;

	public IssueBook(String book_seq, String user_seq, String bname, String uname, Date dateofissue) {
		super();
		this.book_seq = book_seq;
		this.user_seq = user_seq;
		this.bname = bname;
		this.uname = uname;
		this.dateofissue = dateofissue;
	}

	public IssueBook() {}

	public String getBook_seq() {
		return book_seq;
	}

	public void setBook_seq(String book_seq) {
		this.book_seq = book_seq;
	}

	public String getUser_seq() {
		return user_seq;
	}

	public void setUser_seq(String user_seq) {
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
	
	
	
}
