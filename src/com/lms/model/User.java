package com.lms.model;

public class User {
	private String name;
	private String gender;
	private int age;
	private String job;
	private int borrowBookNumber;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String name, String gender, int age, String job, int borrowBookNumber) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.job = job;
		this.borrowBookNumber = borrowBookNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getBorrowBookNumber() {
		return borrowBookNumber;
	}
	public void setBorrowBookNumber(int borrowBookNumber) {
		this.borrowBookNumber = borrowBookNumber;
	}
	
	
}
