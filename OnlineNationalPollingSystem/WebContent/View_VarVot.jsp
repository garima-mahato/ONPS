<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="pollingPack.Voter"%>
<%@page import="java.sql.ResultSet"%><html>
<head>
<title>View_VarVot</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<form action="IssueCardServ" method="post">
<p align="center"><input type="submit" name="submit" value="Issue Card"></p>
	</form>
	<table border="1" bgcolor="gray">
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
int c=0;
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
			<td><a href="<%=url3%>"><img src="<%=url3%>" width="100" height="100"></a></td>
			
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
	
	<form action="LogoutServ" method="post"><p align="center"><input type="submit" value="Logout" class="more"></p></form>
</body>
</html>