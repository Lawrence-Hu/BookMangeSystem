package com.lms.model;

public class Book {
	private int bno;
	private String bname;
	private String publish;
	private String author;
	private float price;
	private String YesorNot;
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(int bno) {
		super();
		this.bno = bno;
	}

	public Book(int bno, String bname, String publish, String author, float price,String YesorNot) {
		super();
		this.bno = bno;
		this.bname = bname;
		this.publish = publish;
		this.author = author;
		this.price = price;
		this.YesorNot = YesorNot;
	}

	public Book(String bname, String publish, String author, float price, String yesorNot) {
		super();
		this.bname = bname;
		this.publish = publish;
		this.author = author;
		this.price = price;
		YesorNot = yesorNot;
	}

	public String getYesorNot() {
		return YesorNot;
	}

	public void setYesorNot(String yesorNot) {
		YesorNot = yesorNot;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getPublish() {
		return publish;
	}

	public void setPublish(String publish) {
		this.publish = publish;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
}
