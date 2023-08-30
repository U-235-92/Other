package com.other.json_test.obj;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.Since;

public class Student {
	private int rollNo;
	@Expose
	private String name;
	@Since(1.1)
	private boolean verified;
	private transient int id;
	public static String className;

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}

	public boolean isVerified() {
		return verified;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + ", verified=" + verified + ", id=" + id + "]";
	}
}
