<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
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
<strong>
<h2 align="center">
<% int r=Integer.parseInt(request.getParameter("p"));
if(r==1)
{%>
Application Failed
<%} %>
<br>
<%if(r==2) {%>
Updation Unsuccessful
<%} %>
<br>
<%if(r==3) {%>
Password Change Unsuccessful
<%} %>
<%if(r==4) {%>
Counting Votes Unsuccessful
<%} %>
</h2>
</strong>
</div>


    
    
                  
    


<div id="templatemo_footer_wrapper">
<div id="templatemo_footer_panel">
     <marquee>Jai Hind!!!!</marquee>
    <div class="margin_bottom_20"></div>
   
</div> <!-- end of footer panel -->
</div> <!-- end of footer wrapper-->
<div align=center>@Designed by NP</div>
</body>
</html>