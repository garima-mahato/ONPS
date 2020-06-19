<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="pollingPack.Voter"%><html>
<head>
<title>voterstatusupdate</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<%String email=request.getParameter("email");
String stat=request.getParameter("st");
Voter v=new Voter();
v.setEmailid(email);
v.setStatus(stat);
v.dbConnection();
v.updatestatus();
v.dbClose();
response.sendRedirect("View_NewApp.jsp");

 %>
</body>
</html>