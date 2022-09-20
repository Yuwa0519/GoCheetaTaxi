package com.assignment.icbt.service;

import javax.sql.DataSource;

import com.assignment.icbt.dao.CustomerDao;
import com.assignment.icbt.entities.Customer;



public class CustomerService {

	public static void addCustomer(DataSource dataSource, Customer customer) {
		CustomerDao.addCustomer(dataSource,customer);
		
	}

	public static boolean checkCredinatial(DataSource dataSource, Customer customer) {
		int checkCredinatial ;
			
		checkCredinatial =	CustomerDao.checkCredinatial(dataSource,customer);
		
		if(checkCredinatial == 1) {
			
			return true ;
		}
		else {
			return false;
		}
		
	}
	
	
	public static Customer getCustomer(DataSource dataSource, String phoneNo) {
		
		return CustomerDao.getCustomer(dataSource, phoneNo);
	}
}
