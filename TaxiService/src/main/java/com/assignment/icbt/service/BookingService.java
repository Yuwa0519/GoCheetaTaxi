package com.assignment.icbt.service;

import java.util.List;

import javax.sql.DataSource;

import com.assignment.icbt.dao.BookingDao;
import com.assignment.icbt.entities.Booking;



public class BookingService {

	public static void addBooking(DataSource dataSource, Booking booking) {
		BookingDao.addBooking(dataSource,booking);
		
	}
	
	public static List<Booking> getBooking(DataSource dataSource,int customerId){
		
		return BookingDao.getBooking(dataSource,customerId);
	}
}
