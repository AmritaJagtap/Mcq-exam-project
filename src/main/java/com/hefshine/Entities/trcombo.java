package com.hefshine.Entities;

public class trcombo {
	
	public int testid;
	public String name;
	public boolean attemped;
	public int marks;
	public int getTestid() {
		return testid;
	}
	public void setTestid(int testid) {
		this.testid = testid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isAttemped() {
		return attemped;
	}
	public void setAttemped(boolean attemped) {
		this.attemped = attemped;
	}
	
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "trcombo [testid=" + testid + ", name=" + name + ", attemped=" + attemped + "]";
	}
	 

}
