package com.example.demo;

import jakarta.persistence.*;

@Entity
public class People {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String fname;
	private String lname;
	private String bDay;
	
	@OneToOne(cascade= CascadeType.ALL)
	private Bank bank;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getbDay() {
		return bDay;
	}

	public void setbDay(String bDay) {
		this.bDay = bDay;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public People(String fname, String lname, String bDay, Bank bank) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.bDay = bDay;
		this.bank = bank;
	}

	public People() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
