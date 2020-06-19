
<%@page import="pollingPack.Vote"%><%@page import="java.sql.ResultSet"%><%
String d=request.getParameter("eid");
int eid=Integer.parseInt(d);
try

{

	Vote  v=new Vote();
	v.dbConnection();
	String pname=null;
	int c=0;
	
    ResultSet rs1=v.result(eid);
	while(rs1.next())
	{
	  pname=rs1.getString(1);
      c=rs1.getInt(2);
		}
		v.dbClose();
		}
	
catch(Exception e)	{
	e.printStackTrace();
}

%>