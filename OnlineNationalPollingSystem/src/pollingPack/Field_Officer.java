package pollingPack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Field_Officer {
	String fid;
	String voter_id;
	int constituency;
	String district;
	String state;
	String status;
	String country;
	
	Connection con=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	public String getVoter_id() {
		return voter_id;
	}
	public void setVoter_id(String voter_id) {
		this.voter_id = voter_id;
	}
	public int getConstituency() {
		return constituency;
	}
	public void setConstituency(int constituency) {
		this.constituency = constituency;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

public void dbConnection()
{
	try
	{
		Class.forName("com.ibm.db2.jcc.DB2Driver");
		con=DriverManager.getConnection("jdbc:db2://localhost:50000/GENPOL","db2admin","db2admin");
    }
	catch(Exception e)
	{
		e.printStackTrace();
		
	}

}


public void dbClose()
{
	try
	{
	con.close();	
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}
public ResultSet display()
{
	try
	{
		pst=con.prepareStatement("select * from db2admin.field_officer");
		rs=pst.executeQuery();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return rs;
	}
public ResultSet display2()
{
	try
	{
		pst=con.prepareStatement("select * from db2admin.Field_Officer where FID=?");
		pst.setString(1,fid);
		rs=pst.executeQuery();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return rs;
	}
public int Insert()
{
	
	int n=0;
	try
	{
		pst=con.prepareStatement("insert into db2admin.field_officer values(?,?,?,?,?,?,?)");
		pst.setString(1,fid);
		pst.setString(2,voter_id);
		pst.setInt(3,constituency);
		pst.setString(4,district);
		pst.setString(5,state);
		pst.setString(6,status);
		pst.setString(7,country);
		n=pst.executeUpdate();
		if(n==1)
		{
		 double d=Math.random();
		 d=d*1000000;
		 String sd="FO"+d;
		 String pwd=sd.substring(0,6);
		 PreparedStatement pst3=con.prepareStatement("insert into db2admin.user_login values(?,?,?)");
		 pst3.setString(1, fid);
		 pst3.setString(2, pwd);
		 pst3.setString(3, "Field Officer");
		 pst3.executeUpdate();
		}	
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return n;
}
public ResultSet getcons_dist()
{
	try
	{
		pst=con.prepareStatement("select * from db2admin.field_officer where fid=?");
		pst.setString(1,fid);
		rs=pst.executeQuery();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return rs;
}

}



