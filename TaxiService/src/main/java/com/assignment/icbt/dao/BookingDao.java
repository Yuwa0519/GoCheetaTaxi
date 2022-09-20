package com.assignment.icbt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.assignment.icbt.entities.Booking;





public class BookingDao {
	
	public static List<Booking> getBooking(DataSource dataSource,int customerId){
		 
		List<Booking> bookings = new ArrayList<Booking>();
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rset  = null;
		String sql = null;
		
		try {
			con = dataSource.getConnection();
			sql= "SELECT bookingid,customerid,bookingdate,droplocation,pickuplocation,bookingstatus,vehicletype FROM bookingtbl where customerid = ?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, customerId);
			rset= stmt.executeQuery();
			
			while(rset.next()) {
				int booking_Id = rset.getInt(1);
				int customerid = rset.getInt(2);
				java.sql.Date bookingdate = rset.getDate(3);
				
				String droplocation = rset.getString(4);
				String pickuplocation = rset.getString(5);
				String bookingstatus = rset.getString(6);
				String vehicletype = rset.getString(7);
				
				Booking booking = new Booking(booking_Id,customerid,bookingdate,droplocation,pickuplocation,bookingstatus,vehicletype
						);
				bookings.add(booking);
				
			}	
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			close(con,stmt,null);
		}
		
		return bookings;
	}

	
	
	public static void addBooking(DataSource dataSource, Booking booking) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			
			con = dataSource.getConnection();
			sql= "INSERT INTO  bookingtbl(customerid,bookingdate,droplocation,pickuplocation,bookingstatus,vehicletype) VALUES "
					+ "(?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, booking.getCustomerid());
			pstmt.setDate(2, booking.getBookingdate());
			pstmt.setString(3, booking.getDroplocation());
			pstmt.setString(4, booking.getPickuplocation());
			pstmt.setString(5, booking.getBookingstatus());
			pstmt.setString(6, booking.getVehicletype());
			
			pstmt.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
				close(con,pstmt,null);
		}
		
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
