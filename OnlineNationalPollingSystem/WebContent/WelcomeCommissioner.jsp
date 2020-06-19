<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="pollingPack.ElectionCommissioner"%>
<%@page import="java.sql.ResultSet"%><html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Online National Polling System</title>
<meta name="keywords" content="css templates, fortune website, CSS, HTML" />
<meta name="description" content="Fortune Template is a free css template from templatemo.com" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%String uid=(String)session.getAttribute("uid");
ElectionCommissioner c=new ElectionCommissioner();
c.setComm_id(uid);
c.dbConnection();
ResultSet rs=c.viewName();
%>
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
        <div class="header_01" style="text-align:center"><h3>Welcome To Commissioner</h3></div>
        <h5 ><ul class="services">
        <li><a href="ViewCommProfile.jsp">View Profile</a></li>
  <li><a href="UploadCommProfile.jsp">Upload Profile</a></li>
  <li><a href="UpdateCommProfile.jsp">Update Profile</a></li>
  <li><a href="ChangePwd.jsp">Change Password</a></li>
  <li><a href="ViewNewCandidateApp.jsp">View Candidate Application</a></li>
  <li><a href="View_VarVot.jsp">View Verified Voter Application</a></li>
  <li><a href="NewElection.jsp">Declare Elections</a></li>
  <li><a href="PublishResult.jsp">Publish Result</a></li>
  <li><a href="NewConsEntry.jsp">New Constituency Entry</a></li>
  <li><a href="NewPartyEntry.jsp">New Party Entry</a></li>
  <li><a href="View_All_Can.jsp">View All Candidate</a></li>
        </ul></h5>
        
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
    
    
    <div class="margin_bottom_20"><form action="LogoutServ" method="post"><p align="center"><input type="submit" value="Logout" class="more"></p></form></div>
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
