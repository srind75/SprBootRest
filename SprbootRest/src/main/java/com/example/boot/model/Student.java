package com.example.boot.model;

import java.util.Date;

import javax.validation.constraints.Future;
import javax.validation.constraints.Past;

import com.example.boot.validator.BirthDate;

public class Student {
	private String id;
	private String name;
	private String dob;
	private String addr;
	
	@BirthDate()
	private String birthDate;
	
	@Past
	@Future
	private Date studentDOB;
	
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", addr=" + addr + ", dob=" + dob + "]";
	}
	
}
