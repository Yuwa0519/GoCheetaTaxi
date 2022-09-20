package com.assignment.icbt.entities;

import java.sql.Date;

import javax.validation.constraints.NotBlank;

public class Booking {
	
	private int bookingid ;
	@NotBlank(message = "is required")
	private int customerid;
	@NotBlank(message = "is required")
	private Date  bookingdate;
	@NotBlank(message = "is required")
	private String droplocation;
	@NotBlank(message = "is required")
	private String pickuplocation;
	@NotBlank(message = "is required")
	private String bookingstatus;
	@NotBlank(message = "is required")
	private String vehicletype;
	
	public Booking() {
		
		
	}
	
	public Booking(int customerid, Date bookingdate, String droplocation, String pickuplocation, String bookingstatus,
			String vehicletype) {
		super();
		this.customerid = customerid;
		this.bookingdate = bookingdate;
		this.droplocation = droplocation;
		this.pickuplocation = pickuplocation;
		this.bookingstatus = bookingstatus;
		this.vehicletype = vehicletype;
	}
	public Booking(int bookingid, int customerid, Date bookingdate, String droplocation, String pickuplocation,
			String bookingstatus, String vehicletype) {
		super();
		this.bookingid = bookingid;
		this.customerid = customerid;
		this.bookingdate = bookingdate;
		this.droplocation = droplocation;
		this.pickuplocation = pickuplocation;
		this.bookingstatus = bookingstatus;
		this.vehicletype = vehicletype;
	}

	public int getBookingid() {
		return bookingid;
	}

	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public Date getBookingdate() {
		return bookingdate;
	}

	public void setBookingdate(Date bookingdate) {
		this.bookingdate = bookingdate;
	}

	public String getDroplocation() {
		return droplocation;
	}

	public void setDroplocation(String droplocation) {
		this.droplocation = droplocation;
	}

	public String getPickuplocation() {
		return pickuplocation;
	}

	public void setPickuplocation(String pickuplocation) {
		this.pickuplocation = pickuplocation;
	}

	public String getBookingstatus() {
		return bookingstatus;
	}

	public void setBookingstatus(String bookingstatus) {
		this.bookingstatus = bookingstatus;
	}

	public String getVehicletype() {
		return vehicletype;
	}

	public void setVehicletype(String vehicletype) {
		this.vehicletype = vehicletype;
	}

	@Override
	public String toString() {
		return "Booking [bookingid=" + bookingid + ", customerid=" + customerid + ", bookingdate=" + bookingdate
				+ ", droplocation=" + droplocation + ", pickuplocation=" + pickuplocation + ", bookingstatus="
				+ bookingstatus + ", vehicletype=" + vehicletype + "]";
	}
	
	
	
	

	
}
