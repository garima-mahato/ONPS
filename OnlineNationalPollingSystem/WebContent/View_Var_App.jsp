<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="pollingPack.Voter"%>
<%@page import="java.sql.ResultSet"%><html xmlns="http://www.w3.org/1999/xhtml">
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
        <div class="header_01" style="text-align:center"><h1>Verified voter</h1></div>
         
           	<table class ="services" border="1" bgcolor="gray">
		<tr>
			<th>Name</th>
			<th>Date_Of_Birth</th>
			<th>Gender</th>
			<th>Age</th>
			<th>Address</th>
			<th>Phone_No</th>
			<th>Email_Id</th>
			<th>Photo</th>
			<th>District</th>
			<th>State</th>
			<th>Country</th>
			<th>Status</th>
			<th>Constituency</th>
			<th>App_Date</th>
			<th>Age_Proof</th>
			<th>Residential</th>
			<th>Guardian</th>
			
			
		</tr>
		<%
try

{
	 Voter  vt1=new Voter();
	vt1.dbConnection();
ResultSet rs=vt1.view1();
	while(rs.next())
	{
		String s1=rs.getString(1);
		String s2=rs.getString(2);
		String s3=rs.getString(3);
		String s4=rs.getString(4);
		String s5=rs.getString(5);
		String s6=rs.getString(6);
		String s7=rs.getString(7);
		String s8=rs.getString(18);
		String s9=rs.getString(9);
		String s10=rs.getString(10);
		String s11=rs.getString(11);
		String s12=rs.getString(12);
		String s13=rs.getString(13);
		String s14=rs.getString(19);
		String s15=rs.getString(20);
		String s16=rs.getString(16);
		String s17=rs.getString(17);  
		String url3="image.jsp?email="+s7+"&imgid="+s8;
        String url4="image1.jsp?email="+s7+"&imgid1="+s14;
		String url5="image2.jsp?email="+s7+"&imgid2="+s15;

		
		%>
		<tr>
			<td><%=s1%></td>
			<td><%=s2%></td>
			<td><%=s3%></td>
			<td><%=s4%></td>
			<td><%=s5%></td>
			<td><%=s6%></td>
			<td><%=s7%></td>
			<td><a href="<%=url3%>"><img src="<%=url3%>" width="100" height="100" /></a></td>
			
			<td><%=s9%></td>
			<td><%=s10%></td>
			<td><%=s11%></td>
			<td><%=s12%></td>
			<td><%=s13%></td>
			<td><%=s17%></td>
			<td><a href="<%=url4%>">click here</a></td>
			<td><a href="<%=url5%>">click here</a></td>
			<td><%=s16%></td>
			</tr>  
<%
	
	}
	vt1.dbClose();

}
catch(Exception e)	{
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


