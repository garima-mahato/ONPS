<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="pollingPack.Voter"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="pollingPack.Election"%>
<%@page import="pollingPack.Candidate"%><html xmlns="http://www.w3.org/1999/xhtml">
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
<div style="font-family:arial;background-color:gray">
<h1 align="center">Cast Vote</h1>
<table align="center">
<tr><td>Select Candidate</td><td>Election ID</td><td>Candidate ID</td><td>Candidate Name</td><td>Party Name</td><td>Party Logo</td><td>Cast Your Vote</td></tr>
<%
Voter v=new Voter();
String uid=(String)session.getAttribute("uid");

v.dbConnection();
v.setVoter_Id(uid);
ResultSet rs=v.getcons_dist();
String dist=null,state=null;
int cons=0;
while(rs.next())
{
dist=rs.getString(9);
state=rs.getString(10);
cons=rs.getInt(13);
}
v.dbClose();
Election e=new Election();
e.dbConnection();
e.setCons_no(cons);
e.setDistrict(dist);
e.setState(state);
int eid=e.getid();
e.dbClose();
Candidate c=new Candidate();
c.setE_id(eid);
c.setConstituency(cons);
c.setDistrict(dist);
c.setState(state);
c.dbConnection();
ResultSet rs1=c.getCandidates();
while(rs1.next())
{
String cid=rs1.getString(16);
String cname=rs1.getString(1);
String pname=rs1.getString(8);
String url="party_image.jsp?imgid="+pname;
 %>
 


<form action="VoteEntryServ" method="post">
<tr><td><input type="radio" name="t1" value="<%=eid%>"></td><td><%=eid%></td><td><%=cid%><input type="hidden" name="t3" value="<%=cid%>" /></td><td><%=cname%><input type="hidden" name="t4" value="<%=cname%>" /></td><td><%=pname%><input type="hidden" name="t5" value="<%=pname%>" /></td><td><img src="<%=url%>" width="100" height="100" /></td><td><input type="submit" value="Cast Vote" /></td>
</tr>
</form>
<%}
c.dbClose(); %>

</table>

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