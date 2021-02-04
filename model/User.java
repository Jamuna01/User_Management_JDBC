package model;

import java.time.LocalDate;

public class User 
{
	private int id;
	private String userName;
	private String password;
	private long mobileNo;
	private LocalDate dob;
	private boolean enable;
	private double salary;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobile_no(long mobile_no) {
		this.mobileNo = mobile_no;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public boolean isEnable() {
		return enable;
	}
	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
}
