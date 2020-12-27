package com.hefshine.Entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Tests {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String tname;
	
	@ManyToMany
	Set<Questions> q;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public Set<Questions> getQ() {
		return q;
	}

	public void setQ(Set<Questions> q) {
		this.q = q;
	}

	
	
	
}
