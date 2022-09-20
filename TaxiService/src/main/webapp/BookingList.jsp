<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<!-- basic -->
<jsp:include page="header.html"></jsp:include>
<title>Go Cheetha</title>

</head>
<body>

	<%
   response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
	if(session.getAttribute("Customer_Id") == null  ){
		response.sendRedirect("index.jsp");
		
	}
	%>

	<!--header section start -->
    <div id="index.html" class="header_section">
        <div class="container">
            <div class="row">
                <div class="col-sm-6 col-lg-3">
                    <div class="logo"><a href="index.html"><img src="resources/images/logo.png"></a></div>
                </div>
                <div class="col-sm-6 col-lg-9">
                    <div class="menu_text">
                        <ul>
                            <li><a href="index.jsp">Home</a></li>                                                    
                            <li><a href="#booking">About</a></li>
                   
                            <li><a href="#booking">Booking</a></li>
                            <li><a href="CustomerServlet">Log Out</a></li>
                            
                            <li><a href="#"><img src="resources/images/search-icon.png"></a></li>
                            <div id="myNav" class="overlay">
                <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
                <div class="overlay-content">
                  <a href="index.html">Home</a>
                  <a href="#booking">About</a>
            
                  <a href="#booking">Booking</a>
                  <a href="CustomerServlet">Log Out</a>
               
                </div>
                </div>
                <span  style="font-size:33px;cursor:pointer; color: #ffffff;" onclick="openNav()"><img src="resources/images/toggle-menu.png" class="toggle_menu"></span>
                </div>  
                </li>
                        </ul>
                    </div>
            </div>
        </div>
    </div>
  
   <br><br>
 <div class="container mt-5 mb-3">
  <h4>
	              Book List
	            </h4>
    <div class="row">
     <div class="alert alert-danger col-md-12 ${exceptionerrorshow}" id="divShowError" role="alert">
						<span id="showerrormsg"class="text-danger">${exceptionerror}</span>
					</div>
 	 <c:forEach  items="${booking_lists}" var="booking_list">
        <div class="col-md-4">
            <div class="card p-3 mb-2">
                <div class="d-flex justify-content-between">
                    
                   
                </div>
                <div class="mt-2">
           				<div class="mt-3"> <span class="text1">	Vehicle : <span class="text2">${booking_list.vehicletype}</span></span> </div>
               			<div class="mt-3"> <span class="text1">Booking Date : <span class="text2">${booking_list.bookingdate}</span></span> </div>
						 <div class="mt-3"> <span class="text1">PickUp : <span class="text2">${booking_list.pickuplocation}</span></span> </div>
               			<div class="mt-3"> <span class="text1">Drop By : <span class="text2">${booking_list.droplocation}</span></span> </div>
						<div class="mt-3"> <span class="text1">Status : <span class="text2">${booking_list.bookingstatus}</span></span> </div>
 						
                </div>
                
            </div>
        </div>
       
       </c:forEach>
       
</div> </div>
  
      <jsp:include page="footer.html"></jsp:include>
   
</body>
</html>