<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page import="pollingPack.Candidate"%>
<%@page import="java.sql.ResultSet"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Online National Polling System</title>
<meta name="keywords" content="css templates, fortune website, CSS, HTML" />
<meta name="description" content="Fortune Template is a free css template from templatemo.com" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="templatemo_header_wrapper">
    <div id="templatemo_header_panel">
    <div id="templatemo_header" font-color:"white"> National Online Polling System        </div>
         <div id="templatemo_tagline">
	     (NOPS)  
        </div>
  </div>
</div>

<div id="templatemo_banner_wrapper">
    <div id="templatemo_banner_panel"><img src="image/par.jpg"/>
    </div>
</div>

<div id="templatemo_menu_wrapper">
    <div id="templatemo_menu_panel">
        <ul>
            <li><a href="Home.jsp" class="current">Home</a></li>
            <li><a href="AboutUs.jsp">About Us</a></li>
            <li><a href="FAQ.jsp">FAQ</a></li>
            <li><a href="Gallery.jsp">Gallery</a></li>  
            <li><a href="Contact.jsp">Contact</a></li> 
            <li><a href="Complaints.jsp">Complaints</a></li>                     
        </ul> 
    </div>
</div> <!-- end of menu -->

<div id="templatemo_content_wrapper">
<div id="templatemo_content_panel">

    <div class="content_panel_3col_section margin_right_60">

        <div class="header_01"></div>
        <div class="image_box_01"><img src="image/m.jpg" alt="Web Template" /></div>
        <div class="p_section"></div>
        
    
    </div>
    
    <div class="content_panel_3col_section margin_right_60">
        <div class="header_01" style="text-align:center"><h5>New Candidate Application</h5><form action="NewCanAppServ" method="post" enctype="multipart/form-data">
<div style="font-family:arial;">

<table align="center">
<tr><td>Name<span style="color:red">*</span>: </td><td><input type="text" name="t1" title="Enter your full name" ></td></tr>

<tr><td>Voter ID<span style="color:red">*</span>: </td><td><input type="text" name="t2" title="Enter your voter identification no."></td></tr>
<tr><td>Email<span style="color:red">*</span>: </td><td><input type="text" name="t3" title="Enter your email id"></td></tr>
<tr><td>Educational Qualification<span style="color:red">*</span>: </td><td><input type="text" name="t5" title="Enter your highest educational qualification"></td></tr>
<tr><td>Constituency<span style="color:red">*</span>: </td><td><input type="text" name="t7" title="Enter the constituency you are applying in"></td></tr>
<tr><td>Party<span style="color:red">*</span>: </td><td><input type="text" name="t8" title="Enter your party name"></td></tr>
<tr><td>District<span style="color:red">*</span>: </td><td><input type="text" name="t9" title="Enter your district"></td></tr>
<tr><td>State<span style="color:red">*</span>: </td><td><input type="text" name="t10" title="Enter your state"></td></tr>
<tr><td>Country<span style="color:red">*</span>: </td><td><input type="text" name="t11" title="Enter your country"></td></tr>
<tr><td>Election ID<span style="color:red">*</span>: </td><td><input type="text" name="t12" title="Enter Election Id"></td></tr>

<tr><td>Upload your photo<span style="color:red">*</span>: </td><td><input type="file" name="t4"></td></tr>
<tr><td>Upload your qualification certificate<span style="color:red">*</span>: </td><td><input type="file" name="t6"></td></tr>
<tr><td align="center"><input type="submit" value="Submit"></td><td align="center"><input type="submit" value="Reset"></td></tr>
</table>
</div>
<h6>Fields with <span style="color:red">*</span> are mandatory</h6>
</form>






        
    </div>
    
    <div class="content_panel_3col_section">
        <div class="header_01"></div>
        
        <div class="news_section">
            
      </div>
        <div class="margin_bottom_30"></div>
    
        <div class="news_section">
            <div class="news_content">
                <div class="news_title"></div>
                
                
            </div>
        </div>
    
    	<div class="margin_bottom_30"></div>
    
        <div class="news_section">
            <div class="news_content">
                <div class="news_title"></div>
                	</div>
    	</div>
    </div>                
    
    <div class="margin_bottom_20"></div>
</div> <!-- end of content panel -->
</div> <!-- end of content wrapper -->

<div id="templatemo_footer_wrapper">
<div id="templatemo_footer_panel">
     <marquee>Jai Hind!!!!</marquee>
    <div class="margin_bottom_20"></div>
   
</div> <!-- end of footer panel -->
</div> <!-- end of footer wrapper-->
<div align=center>@Designed by NP</div>
</body>
</html>


