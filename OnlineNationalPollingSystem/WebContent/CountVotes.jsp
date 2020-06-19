<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="java.sql.ResultSet"%>
<%@page import="pollingPack.Vote"%><html xmlns="http://www.w3.org/1999/xhtml">
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
<h3 align="center">Count Votes</h3>
<form action="CountVoteServ" method="post">
<center><input type="submit" value="Count Votes"></center>
</form>
<table border="1" bgcolor="gray" align="center">
		<tr>
			<th>Election ID</th>
			<th>Voter ID</th>
			<th>Candidate ID</th>
			<th>Candidate Name</th>
			<th>Party Name</th>
			<th>Status</th>
			</tr>
		<%
try

{
	 Vote  vt1=new Vote();
	vt1.dbConnection();
ResultSet rs=vt1.view();
int c=0;
	while(rs.next())
	{
	c++;
		String s1=rs.getString(1);
		String s2=rs.getString(2);
		String s3=rs.getString(3);
		String s4=rs.getString(4);
		String s5=rs.getString(5);
		String s6=rs.getString(6);
		%>
		<tr>
			<td><%=s1%></td>
			<td><%=s2%></td>
			<td><%=s3%></td>
			<td><%=s4%></td>
			<td><%=s5%></td>
			<td><%=s6%></td>
			
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