package com.assignment.icbt.entities;

import javax.validation.constraints.NotBlank;

public class Customer {
	
	private int customerid;
	
	@NotBlank(message = "is required")
	private String customername;
	
	@NotBlank(message = "is required")
	private String username;
	
	@NotBlank(message = "is required")
	private String password;

	
	
	public Customer(){

	}



	public Customer(String customername, String username, String password) {
		super();
		this.customername = customername;
		this.username = username;
		this.password = password;
	}

	public Customer(String username, String password) {
		super();

		this.username = username;
		this.password = password;
	}

	public Customer(int customerid, String customername, String username, String password) {
		super();
		this.customerid = customerid;
		this.customername = customername;
		this.username = username;
		this.password = password;
	}



	public int getCustomerid() {
		return customerid;
	}



	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}



	public String getCustomername() {
		return customername;
	}



	public void setCustomername(String customername) {
		this.customername = customername;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
