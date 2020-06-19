<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="pollingPack.Election"%>
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
<table border="1" bgcolor="gray" align="center">
		<tr>
			<th>Election ID</th>
			<th>Constituency</th>
			<th>District</th>
			<th>State</th>
			<th>Country</th>
			<th>Election Type</th>
			<th>Election Date</th>
			</tr>



<%  String bt=request.getParameter("bt1");
if(bt.equals("Constitute Wise Search"))
{
String s1=request.getParameter("t1");
String s2=request.getParameter("t2");
String s3=request.getParameter("t3");
String s4=request.getParameter("t4");

	 Election e=new Election();
		 e.setCons_no(Integer.parseInt(s1));
	 e.setDistrict(s2);
	 e.setState(s3);
	 e.setCountry(s4);
	 
	e.dbConnection();
    ResultSet rs=e.display5();
	while(rs.next())
	{
		int ss1=rs.getInt(1);
		int ss2=rs.getInt(2);
		String ss3=rs.getString(3);
		String ss4=rs.getString(4);
		String ss5=rs.getString(5);
		String ss6=rs.getString(6);
		String ss7=rs.getString(7);
		%>
		<tr>
			<td><%=ss1%></td>
			<td><%=ss2%></td>
			<td><%=ss3%></td>
			<td><%=ss4%></td>
			<td><%=ss5%></td>
			<td><%=ss6%></td>
			<td><%=ss7%></td>
		</tr>  
<%
	
	}
	e.dbClose();


}
if(bt.equals("District Wise Search"))
{
String s1=request.getParameter("t1");
String s2=request.getParameter("t2");
String s3=request.getParameter("t3");


	 Election e=new Election();
	 e.setDistrict(s1);
	 e.setState(s2);
	 e.setCountry(s3);
	 
	e.dbConnection();
    ResultSet rs=e.display6();
	while(rs.next())
	{
		int ss1=rs.getInt(1);
		int ss2=rs.getInt(2);
		String ss3=rs.getString(3);
		String ss4=rs.getString(4);
		String ss5=rs.getString(5);
		String ss6=rs.getString(6);
		String ss7=rs.getString(7);
		%>
		<tr>
			<td><%=ss1%></td>
			<td><%=ss2%></td>
			<td><%=ss3%></td>
			<td><%=ss4%></td>
			<td><%=ss5%></td>
			<td><%=ss6%></td>
			<td><%=ss7%></td>
		</tr>  
<%
	
	}
	e.dbClose();


}
if(bt.equals("State Wise Search"))
{
String s1=request.getParameter("t1");
String s2=request.getParameter("t2");

	 Election e=new Election();
	 e.setState(s1);
	 e.setCountry(s2);
	 
	e.dbConnection();
    ResultSet rs=e.display7();
	while(rs.next())
	{
		int ss1=rs.getInt(1);
		int ss2=rs.getInt(2);
		String ss3=rs.getString(3);
		String ss4=rs.getString(4);
		String ss5=rs.getString(5);
		String ss6=rs.getString(6);
		String ss7=rs.getString(7);
		%>
		<tr>
			<td><%=ss1%></td>
			<td><%=ss2%></td>
			<td><%=ss3%></td>
			<td><%=ss4%></td>
			<td><%=ss5%></td>
			<td><%=ss6%></td>
			<td><%=ss7%></td>
		</tr>  
<%
	
	}
	e.dbClose();


}if(bt.equals("Country Wise Search"))
{
String s1=request.getParameter("t1");

	 Election e=new Election();
	 e.setCountry(s1);
	 
	e.dbConnection();
    ResultSet rs=e.display8();
	while(rs.next())
	{
		int ss1=rs.getInt(1);
		int ss2=rs.getInt(2);
		String ss3=rs.getString(3);
		String ss4=rs.getString(4);
		String ss5=rs.getString(5);
		String ss6=rs.getString(6);
		String ss7=rs.getString(7);
		%>
		<tr>
			<td><%=ss1%></td>
			<td><%=ss2%></td>
			<td><%=ss3%></td>
			<td><%=ss4%></td>
			<td><%=ss5%></td>
			<td><%=ss6%></td>
			<td><%=ss7%></td>
		</tr>  
<%
	
	}
	e.dbClose();


}
 %>
 </table>



    
    
                  
    
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