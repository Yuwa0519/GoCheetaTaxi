<!DOCTYPE html>
<html lang="en">
<head>
<!-- basic -->
<jsp:include page="header.html"></jsp:include>
<title>Go Cheetha</title>

</head>
<body>
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
                   
                            <li><a href="booking.jsp">Booking</a></li>
                             <li><a href="CustomerServlet">Log Out</a></li>
                            
                            <li><a href="#"><img src="resources/images/search-icon.png"></a></li>
                            <div id="myNav" class="overlay">
                <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
                <div class="overlay-content">
                  <a href="index.html">Home</a>
                  <a href="#booking">About</a>
            
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
    <!-- header section end -->
    <!-- banner section start -->
    <div class="banner_section">
      <div class="container-fluid">
        <div id="main_slider" class="carousel slide" data-ride="carousel">
  <div class="carousel-inner">
    <div class="carousel-item active">
      <div class="row">
          <div class="col-md-6">
            
            <div class="image_1"><img src="resources/images/img-1.png"></div>
          </div>
          <div class="col-md-6">
       
            <div class="contact_bg">
            <form action="CustomerServlet" method="post" >
	            <input type="hidden" name="command" value="LOGIN">
            <div class="input_main">
              <div class="container">
                <h2 class="request_text">Login </h2>
                	
                   	<div class="form-group">
	                   <div class="alert alert-danger col-md-12 ${exceptionerrorshow}" id="divShowError" role="alert">
					<span id="showerrormsg"class="text-danger">${exceptionerror}</span>
				</div>
	                </div>
                <div class="form-group">
                  <input type="text" class="email-bt" placeholder="username" name="username">
                </div>
                <div class="form-group">
                  <input type="password" class="email-bt" placeholder="password" name="password">
                </div>
               
                 <div class="form-group">
                  <button type="submit" class="btn btn-primary ">Login</button> &nbsp  <a href="register.jsp" class="btn btn-secondary ">Register</a>
                </div>
                  </div> 
                  </div>
               
                 </form>
          </div>
          </div>
        </div>
    </div>
    </div>
 
</div>
        
      </div>
    </div>
    <!-- banner section end -->
   
    <!-- why ride section start -->
    <div id="booking" class="ride_section layout_padding">
      <div class="container">
        <div class="ride_main">
          <h1 class="ride_text">Why Ride <span style="color: #f4db31;">With Go Cheetha</span></h1>
      </div>
        </div>
    </div>
    <div class="ride_section_2 layout_padding">
      <div class="container">
        <div class="row">
          <div class="col-sm-4">
            <div class="image_3"><img src="resources/images/img-3.png"></div>
          </div>
          <div class="col-sm-8">
            <h1 class="cabe_text">Go Cheetha for Every Pocket</h1>
            <p class="long_text">It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as It is a long established fact that a reader will be distracted by the readable c</p>
            <div class="book_bt"><a href="#">BOOK NOW</a></div>
          </div>
        </div>
      </div>
      <div class="container">
        <div class="row">
          <div class="col-sm-8">
            <h1 class="secure_text">Secure and Safer Rides</h1>
            <p class="long_text_2">It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as It is a long established fact that a reader will be distracted by the readable c</p>
            <div class="book_bt_2"><a href="#">BOOK NOW</a></div>
          </div>
          <div class="col-sm-4">
            <div class="image_3"><img src="resources/images/img-4.png"></div>
          </div>
        </div>
      </div>
      <div class="container">
        <div class="row">
          <div class="col-sm-4">
            <div class="image_3"><img src="resources/images/img-5.png"></div>
          </div>
          <div class="col-sm-8">
            <h1 class="cabe_text">Go Cheetha for Every Pocket</h1>
            <p class="long_text">It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as It is a long established fact that a reader will be distracted by the readable c</p>
            <div class="book_bt"><a href="#">BOOK NOW</a></div>
          </div>
        </div>
      </div>
      <div class="container">
        <div class="row">
          <div class="col-sm-8">
            <h1 class="secure_text">Secure and Safer Rides</h1>
            <p class="long_text_2">It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as It is a long established fact that a reader will be distracted by the readable c</p>
            <div class="book_bt_2"><a href="#">BOOK NOW</a></div>
          </div>
          <div class="col-sm-4">
            <div class="image_3"><img src="resources/images/img-5.png"></div>
          </div>
        </div>
      </div>
    </div>
    <!-- why ride section end -->
    <!-- location section start -->
    <div id="contact" class="location_sectin layout_padding">
      <div class="container-fluid">
        <div class="location_main">
          <div class="row">
            <div class="col-sm-4"></div>
            <div class="col-sm-5">
              <div class="download_text">DOWNLOAD<br><span style="color: #fffcf4;">OUR APP TODAY</span></div>
            </div>
            <div class="col-sm-3">
              <div class="image_7"><img src="resources/images/img-7.png"></div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- download section end -->
  
  <jsp:include page="footer.html"></jsp:include>
   
</body>
</html>