<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>NewPartyEntry</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<form action="NewPartyEntryServ" method="post" enctype="multipart/form-data">
<div style="font-family:arial;background-color:gray">
<h1 align="center">New Party Entry</h1>
<table align="center">
<tr><td>Party Name<span style="color:red">*</span>: </td><td><input type="text" name="t1" title="Enter party name"></td></tr>
<tr><td>Party Head<span style="color:red">*</span>: </td><td><input type="text" name="t2" title="Enter party head"></td></tr>
<tr><td>Upload logo<span style="color:red">*</span>: </td><td><input type="file" name="t3"></td></tr>
<tr></tr>
<tr><td align="center"><input type="submit" value="Submit"></td><td align="center"><input type="submit" value="Reset"></td></tr>
</table>
</div>
Fields with <span style="color:red">*</span> are mandatory
</form>
</body>
</html>