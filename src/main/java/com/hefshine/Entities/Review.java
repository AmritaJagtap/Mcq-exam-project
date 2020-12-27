package com.hefshine.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Review {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	@ManyToOne
	public Tests tests;
	@ManyToOne
	public Students students;
	
	@ManyToOne
	public Questions question;
	public int userchoice;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Tests getTests() {
		return tests;
	}
	public void setTests(Tests tests) {
		this.tests = tests;
	}
	public Students getStudents() {
		return students;
	}
	public void setStudents(Students students) {
		this.students = students;
	}
	public Questions getQuestion() {
		return question;
	}
	public void setQuestion(Questions question) {
		this.question = question;
	}
	public int getUserchoice() {
		return userchoice;
	}
	public void setUserchoice(int userchoice) {
		this.userchoice = userchoice;
	}
	
	
	
	

}
