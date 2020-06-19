<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="pollingPack.Voter"%>
<%@page import="java.sql.ResultSet"%><html>
<head>
<title>images</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<%
if(request.getParameter("imgid")!=null && request.getParameter("imgid")!="")
{
   String  fname = request.getParameter("imgid");
   String voter_Id=request.getParameter("voter_Id");
  try{  
     // File f = new File ("C://Users//db2admin//Desktop//img"+fname);
      
      Voter v=new Voter();
      v.dbConnection();
      ResultSet rs=v.showimags(voter_Id);
           byte[] xx=null;
      if(rs.next())
      {
    	  xx=rs.getBytes(1);
      }
//FileOutputStream fout=new FileOutputStream(f);
//fout.write(xx);
//FileInputStream ff = new FileInputStream(f); 
int length = xx.length;
//byte[] fileBytes=new byte[length];
//ff.read(xx , 0 , length);
response.reset();
response.setContentType("image/jpg");
response.setHeader("Content-disposition","attachment; filename=" +fname);
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