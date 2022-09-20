<!DOCTYPE html>
<html lang="en">
<head>
<!-- basic -->
<jsp:include page="header.html"></jsp:include>
<title>Go Cheetha</title>

</head>
<body>
	<!--header section start -->
	<%
		   response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
			if(session.getAttribute("Customer_Id") != null  ){
				response.sendRedirect("booking.jsp");
				
			}
		%>
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
                            <li><a href="index.jsp#bookings">About</a></li>
                   
                            <li><a href="#booking">Booking</a></li>
                            <li><a href="CustomerServlet">Log Out</a></li>
                            
                            <li><a href="#"><img src="resources/images/search-icon.png"></a></li>
                            <div id="myNav" class="overlay">
                <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
                <div class="overlay-content">
                  <a href="index.jsp">Home</a>
                  <a href="index.jsp#booking">About</a>
            
                  <a href="booking.jsp">Booking</a>
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
  <div class="carousel-inner">
    <div class="carousel-item active">
      <div class="row">
          <div class="col-md-4">
            
            <div class="image_1"><img src="resources/images/img-1.png"></div>
          </div>
          <div class="col-md-7">
        <form  action="CustomerServlet" method="post">
            <div class="contact_bg">
            <div class="input_main">
              <div class="container">
                <h2 class="request_text">Register </h2>
               
                    <input type="hidden" name="command" value="REGISTER">
                    
                    <div class="form-group row ">
						<label class = "col-4 col-form-label " for="txtpassword">Name</label>
                        <div class="col-8"> 
                         	<input type="text" class="form-control" name="customer_Name" >
								
						</div>
                   	</div>
                   	
                   	<div class="form-group row ">
						<label class = "col-4 col-form-label " for="txtpassword">UserName</label>
                        <div class="col-8"> 
                         	<input type="text" class="form-control" name="username" >
								
						</div>
                   	</div>
                   	
                   	<div class="form-group row ">
						<label class = "col-4 col-form-label " for="txtpassword">Password</label>
                        <div class="col-8"> 
                         	<input type="password" class="form-control" name="password">
								
						</div>
                   	</div>
                   	
                
                   	
                   	<div class="form-group row ">
						<div class="alert alert-danger col-md-12 ${exceptionerrorshow}" id="divShowError" role="alert">
						<span id="showerrormsg"class="text-danger">${exceptionerror}</span>
					</div>
                   	</div>
                  
                  	<div class="form-group row ">
						 <button type="submit" id="btnSubmit" class="btn btn-primary ">Register</button> 
						  
					</div>
                   	</div>
                  </div> 
                  </div>
               
               
                
          
          </form>
          </div>
        </div>
    </div>
       </div>
 

  
      <jsp:include page="footer.html"></jsp:include>
   
</body>
</html>