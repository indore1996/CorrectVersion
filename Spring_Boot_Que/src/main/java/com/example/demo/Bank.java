package com.example.demo;

import jakarta.persistence.*;

@Entity
public class Bank {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String Bname;
	private String pNo;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBname() {
		return Bname;
	}
	public void setBname(String bname) {
		Bname = bname;
	}
	public String getpNo() {
		return pNo;
	}
	public void setpNo(String pNo) {
		this.pNo = pNo;
	}
	public Bank(String bname, String pNo) {
		super();
		Bname = bname;
		this.pNo = pNo;
	}
	public Bank() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}