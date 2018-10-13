package com.lms.model;

public class User {

	private String name;
	private String sex;
	private int id;
	private int age;
	private String professional;
	private int borrowBookNumber;

	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(String name) {
		super();
		this.name = name;
	}
	
	public User(int id) {
		super();
		this.id = id;
	}

	public User(int id, String name, String sex, int age, String professional) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.professional = professional;
	}

	public User(String name, String sex, int age, String professional, int borrowBookNumber) {
		super();
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.professional = professional;
		this.borrowBookNumber = borrowBookNumber;
	}
	

	public User(String name, String sex, int age, String professional) {
		super();
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.professional = professional;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getsex() {
		return sex;
	}
	public void setsex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public String getProfessional() {
		return professional;
	}
	public void setProfessional(String professional) {
		this.professional = professional;
	}
	public int getborrowBookNumber() {
		return borrowBookNumber;
	}
	public void setborrowBookNumber(int borrowBookNumber) {
		this.borrowBookNumber = borrowBookNumber;
	}	
//zheshicheshi
}
