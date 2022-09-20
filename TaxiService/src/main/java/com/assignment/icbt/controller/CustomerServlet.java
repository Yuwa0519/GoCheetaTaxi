package com.assignment.icbt.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.assignment.icbt.entities.Customer;
import com.assignment.icbt.service.CustomerService;
import com.assignment.icbt.utils.EntityValidator;


@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Resource(name ="jdbc/gocheetha_application")
	private DataSource dataSource;
    public CustomerServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String command =request.getParameter("command");
		
		if(command == null )
		{
			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect("index.jsp");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command =request.getParameter("command");
		
		if(command.equals("REGISTER") )
		{
			register(request,response);
		}
		
		if(command.equals("LOGIN") )
		{
			 login(request,response);
		}
	}
	
	
	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Customer cust = new Customer(username,password);
		
		try {
	
			if(CustomerService.checkCredinatial(dataSource,cust)) {
				
			Customer customer = CustomerService.getCustomer(dataSource, username);
			HttpSession session = request.getSession();
			session.setAttribute("Customer_Id", customer.getCustomerid());
			session.setAttribute("Customer_Name", customer.getCustomername());
			session.setAttribute("username", customer.getUsername());
			response.sendRedirect("booking.jsp");
			}
			else {
				request.setAttribute("exceptionerror","User Credinatial incorrect");
				request.setAttribute("exceptionerrorshow", "");
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
		
	} catch (Exception e) {
		
		request.setAttribute("exceptionerror", e.toString());
		request.setAttribute("exceptionerrorshow", "");
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		
	}
		
	}
	
	private void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
				
				
			
					String customer_Name = request.getParameter("customer_Name");
					String password = request.getParameter("password");
					String username = request.getParameter("username");
					Customer cust = new Customer(customer_Name,username,password);
					
					EntityValidator<Customer> validator = new EntityValidator<Customer>();
					String errors = validator.validate(cust);
					
					if(!errors.isEmpty()) {
						request.setAttribute("customer", cust);
						request.setAttribute("error", errors);
						request.getRequestDispatcher("/register.jsp").forward(request, response);
					}else {
						CustomerService.addCustomer(dataSource, cust);

						 response.sendRedirect("index.jsp");
					}

		} catch (Exception e) {
			
			request.setAttribute("exceptionerror", e.toString());
			request.setAttribute("exceptionerrorshow", "");
			request.getRequestDispatcher("/register.jsp").forward(request, response);
	}
		
		
		
	
	
}


}
