package com.lms.model;

public class User {
	private String name;
	private String sex;
	private int id;
	private int age;
	private String professional;
	private int num_of_book;
	
	public User(String name, String sex, int id, int age, String professional, int num_of_book) {
		super();
		this.name = name;
		this.sex = sex;
		this.id = id;
		this.age = age;
		this.professional = professional;
		this.num_of_book = num_of_book;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getNum_of_book() {
		return num_of_book;
	}
	public void setNum_of_book(int num_of_book) {
		this.num_of_book = num_of_book;
	}	
	
}
