package com.hefshine.Entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Questions {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String qname;
	String qa;
	String qb;
	String qc;
	String qd;
	int ans;
	
	@ManyToMany(mappedBy = "q")
	Set<Tests> t;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQname() {
		return qname;
	}

	public void setQname(String qname) {
		this.qname = qname;
	}

	public String getQa() {
		return qa;
	}

	public void setQa(String qa) {
		this.qa = qa;
	}

	public String getQb() {
		return qb;
	}

	public void setQb(String qb) {
		this.qb = qb;
	}

	public String getQc() {
		return qc;
	}

	public void setQc(String qc) {
		this.qc = qc;
	}

	public String getQd() {
		return qd;
	}

	public void setQd(String qd) {
		this.qd = qd;
	}

	public int getAns() {
		return ans;
	}

	public void setAns(int ans) {
		this.ans = ans;
	}

	public Set<Tests> getT() {
		return t;
	}

	public void setT(Set<Tests> t) {
		this.t = t;
	}

	@Override
	public String toString() {
		return "Questions [id=" + id + ", qname=" + qname + ", qa=" + qa + ", qb=" + qb + ", qc=" + qc + ", qd=" + qd
				+ ", ans=" + ans + "]";
	}
	
	
}
