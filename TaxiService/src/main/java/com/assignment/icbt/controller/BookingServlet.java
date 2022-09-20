package com.assignment.icbt.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.assignment.icbt.entities.Booking;
import com.assignment.icbt.service.BookingService;
import com.assignment.icbt.utils.EntityValidator;




@WebServlet("/BookingServlet")
public class BookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Resource(name ="jdbc/gocheetha_application")
	private DataSource dataSource;
    public BookingServlet() {
        super();
      
    }

	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command =null;
		command = request.getParameter("command");
		
		if(command == null )
		{
			mainList(request,response);
		}
		if(command.equals("SHOW-LIST") )
		{
			mainList(request,response);
		}
			
			
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String command =null;
		command = request.getParameter("command");
		if(command.equals("ADDBOOKING") )
		{
			addData(request, response);
		}
	}
	
	
	private void mainList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			int customer_Id = (int) session.getAttribute("Customer_Id");
			List<Booking> booking =  BookingService.getBooking(dataSource,customer_Id);
			request.setAttribute("booking_lists", booking);
			request.setAttribute("exceptionerrorshow", "d-none");
			request.getRequestDispatcher("/BookingList.jsp").forward(request, response);
		}catch (Exception e) {
			request.setAttribute("exceptionerror", e.toString());
			request.setAttribute("exceptionerrorshow", "");
			request.getRequestDispatcher("/BookingList.jsp").forward(request, response);
		}
		
	}

	
	private void addData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
				HttpSession session = request.getSession();
				String bookingstatus = "p";
				String vehicletype = request.getParameter("vehicle_category_Id");
				int customerid = (int) session.getAttribute("Customer_Id");
				String pickuplocation = request.getParameter("source_Location");
				String droplocation = request.getParameter("destinationation_Location");
				String getbooking_Date = request.getParameter("booking_Date");
				Date bookingdate=Date.valueOf(getbooking_Date);

				Booking booking = new Booking( customerid,  bookingdate,  droplocation,  pickuplocation,  bookingstatus,vehicletype);
				
				EntityValidator<Booking> validator = new EntityValidator<Booking>();
				String errors = validator.validate(booking);
				request.setAttribute("exceptionerrorshow", "d-none");
				if(!errors.isEmpty()) {
					request.setAttribute("booking", booking);
					request.setAttribute("error", errors);
					request.getRequestDispatcher("/booking.jsp").forward(request, response);
				}else {
						BookingService.addBooking(dataSource, booking);
				
						 response.sendRedirect(request.getContextPath() +"/BookingServlet?command=SHOW-LIST");
				}
			
			
		} catch (Exception e) {
			
			request.setAttribute("exceptionerror", e.toString());
			request.setAttribute("exceptionerrorshow", "");
			request.getRequestDispatcher("/booking.jsp").forward(request, response);
		}
		
	}


}
