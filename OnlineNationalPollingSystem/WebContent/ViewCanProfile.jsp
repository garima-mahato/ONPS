<!DOCTYPE html>

<%@page import="pollingPack.Candidate"%>
<%@page import="java.sql.ResultSet"%><html>

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
        <div class="header_01" style="text-align:center">Your Profile</div>
         
           	<table class="services"  border="1" bgcolor="gray">

<tr><th>Name</th><th>Voter ID</th><th>Email ID</th><th>Photo</th><th>Educational Qualification</th><th>Constituency</th><th>Party Name</th><th>Applied Date</th><th>District</th><th>State</th><th>Country</th><th>Status</th><th>Candidate ID</th></tr>

<%
try
{
String uid=(String)session.getAttribute("uid");
Candidate c=new Candidate();
c.setCid(uid);
c.dbConnection();
ResultSet r=c.viewProfile();
while(r.next())
	 {
		 String s1=r.getString(1);
		String s2=r.getString(2);
		String s3=r.getString(3);
		String s4=r.getString(5);
		String s5=r.getString(7);
		String s6=r.getString(8);
		String s7=r.getString(9);
		String s8=r.getString(10);
		String s9=r.getString(11);
		String s10=r.getString(12);
		String s12=r.getString(14);
		String s13=r.getString(15);
		int s11=r.getInt(16);
		 String url3="imageCan.jsp?email="+s3+"&imgid="+s12;
        String url4="imageCanQualification.jsp?email="+s3+"&imgid1="+s13;
%>
	<tr><td><%=s1%></td><td><%=s2%></td><td><%=s3%></td><td><%=s4%></td><td><%=s5%></td><td><%=s6%></td><td><%=s7%></td><td><%=s8%></td><td><%=s9%></td><td><%=s10%></td><td><%=s11%></td><td><%=s12%></td><td><%=s13%></td></tr>	 
		 <%
	 }
	 c.dbClose();
}
catch(Exception e)
{
	e.printStackTrace();
}

%>
</table>
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
 