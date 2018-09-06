package com.cg.employee.bean;

import java.time.LocalDate;

public class Employee {
	private int id;
	private String name;
	private String gender;
	private int age;
	private LocalDate doj;
	private String designation;
	private String mobile;
	private double salary;
	
	// getters and setters for the parameters
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
	public LocalDate getDoj() {
		return doj;
	}
	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	//Parameterized constructor
	public Employee(int id, String name, String gender, int age, LocalDate doj,
			String designation, String mobile, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.doj = doj;
		this.designation = designation;
		this.mobile = mobile;
		this.salary = salary;
	}
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	//over-riding TOSTRING method
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", gender=" + gender
				+ ", age=" + age + ", doj=" + doj + ", designation="
				+ designation + ", mobile=" + mobile + ", salary=" + salary
				+ "]";
	}
}
