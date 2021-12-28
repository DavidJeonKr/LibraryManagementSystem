package com.david.vo;


public class Book {
	private int book_seq;
	private String book_title;
	private long book_isbn;
	private String book_autor;
	private String book_publisher;
	private int book_pages;
	private int book_price;
	private int book_code;
	private int book_rent;


	public Book(int book_seq, long book_isbn, String book_autor, String book_publisher, int book_pages,
			int book_price, int book_code, String book_title) {
		super();
		this.book_seq = book_seq;
		this.book_isbn = book_isbn;
		this.book_autor = book_autor;
		this.book_publisher = book_publisher;
		this.book_pages = book_pages;
		this.book_price = book_price;
		this.book_code = book_code;
		this.book_title = book_title;
	}
	public Book( String book_title, long book_isbn, String book_autor, String book_publisher, int book_pages,
			int book_price, int book_code) {
		this.book_isbn = book_isbn;
		this.book_autor = book_autor;
		this.book_publisher = book_publisher;
		this.book_pages = book_pages;
		this.book_price = book_price;
		this.book_code = book_code;
		this.book_title = book_title;
	}

	public int getRent() {
		return book_rent;
	}
	public void setRent(int rent) {
		this.book_rent = rent;
	}
	
	public Book() {
	}
	public int getBook_seq() {
		return book_seq;
	}

	public void setBook_seq(int book_seq) {
		this.book_seq = book_seq;
	}

	public long getBook_isbn() {
		return book_isbn;
	}

	public void setBook_isbn(long book_isbn) {
		this.book_isbn = book_isbn;
	}

	public String getBook_autor() {
		return book_autor;
	}

	public void setBook_autor(String book_autor) {
		this.book_autor = book_autor;
	}

	public String getBook_publisher() {
		return book_publisher;
	}

	public void setBook_publisher(String book_publisher) {
		this.book_publisher = book_publisher;
	}

	public int getBook_pages() {
		return book_pages;
	}

	public void setBook_pages(int book_pages) {
		this.book_pages = book_pages;
	}

	public int getBook_price() {
		return book_price;
	}

	public void setBook_price(int book_price) {
		this.book_price = book_price;
	}

	public int getBook_code() {
		return book_code;
	}

	public void setBook_code(int book_code) {
		this.book_code = book_code;
	}

	public String getBook_title() {
		return book_title;
	}

	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}

	@Override
	public String toString() {
		String result = book_seq + " | " + book_isbn + " | " + book_autor + " | " + book_publisher + " | " + book_pages
				+ " | " + book_price + " | " + book_code + " | " + book_title;
		return result;
	}

}