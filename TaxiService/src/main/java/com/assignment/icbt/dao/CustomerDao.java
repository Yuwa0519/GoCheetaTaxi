package com.assignment.icbt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.assignment.icbt.entities.Customer;



public class CustomerDao {
	
	public static void addCustomer(DataSource dataSource, Customer customer) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			con = dataSource.getConnection();
			sql= "insert into customer (customername,username,password) values(?,?,?)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, customer.getCustomername());
			pstmt.setString(2, customer.getUsername());
			pstmt.setString(3, customer.getPassword());
			
			pstmt.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
				close(con,pstmt,null);
		}
		
	}
	

	public static Customer getCustomer(DataSource dataSource, String phoneNo) {
		Customer cust = null;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rset  = null;
		String sql = null;
		
		try {
			con = dataSource.getConnection();
			sql= "select * from customer where username = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, phoneNo);
			rset= stmt.executeQuery();
			
			while(rset.next()) {
				int customer_Id = rset.getInt("customerid");
				String customer_Name = rset.getString("customername");
				String username = rset.getString("username");
				String password = rset.getString("password");
				
				cust = new Customer(customer_Id,customer_Name,username,password);
				
				
			}	
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			close(con,stmt,null);
		}
		
		return cust;
	}
	
	public static int checkCredinatial(DataSource dataSource,Customer customer) {
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rset  = null;
		String sql = null;
		int returnVal = 0;
		
		try {
			con = dataSource.getConnection();
			sql= "select * from customer where username = ? and password=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, customer.getUsername());
			stmt.setString(2, customer.getPassword());
			rset= stmt.executeQuery();
			
			if(rset.next()) {
				returnVal = 1;
				
			}	
			else {
				returnVal = 0;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			close(con,stmt,null);
		}
		
		return returnVal;
	}

	
	private static void close(Connection con,Statement stmt,ResultSet rset) {
		try {
			if(rset != null)
			{
				rset.close();
			}
			if(stmt != null)
			{
				stmt.close();
			}
			
			if(con != null)
			{
				con.close();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}


}
