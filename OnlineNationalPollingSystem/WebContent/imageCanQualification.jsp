<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.io.File"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.io.FileOutputStream"%>

<%@page import="pollingPack.Candidate"%><html>
<head>
<title>imageCanQualification</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<%
if(request.getParameter("imgid1")!=null && request.getParameter("imgid1")!="")
{
   String  fname1 = request.getParameter("imgid1");
   String email=request.getParameter("email");
  try{  
      File f = new File ("C:\\Users\\db2admin\\Desktop\\img"+fname1);
      
      Candidate v=new Candidate();
      v.dbConnection();
      ResultSet rs=v.showimagCan1(email);
           byte[] xx=null;
      if(rs.next())
      {
    	  xx=rs.getBytes(1);
      }
FileOutputStream fout=new FileOutputStream(f);
fout.write(xx);
FileInputStream ff = new FileInputStream(f); 
int length = xx.length;
//byte[] fileBytes=new byte[length];
ff.read(xx , 0 , length);
response.reset();
response.setContentType("image/jpg");
response.setHeader("Content-disposition","attachment; filename=" +fname1);
response.getOutputStream().write(xx,0,length); 
response.getOutputStream().flush();  
v.dbClose();
out.clear();
out = pageContext.pushBody();

 }
  catch (Exception e){

  e.printStackTrace();

  }

}


%>
</body>
</html>