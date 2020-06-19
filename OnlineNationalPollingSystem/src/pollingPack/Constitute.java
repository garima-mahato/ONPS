package pollingPack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Constitute {
	String district,state,country;
	int cons_no;
   
	Connection con=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
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
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getCons_no() {
		return cons_no;
	}
	public void setCons_no(int cons_no) {
		this.cons_no = cons_no;
	}
	
	public void  dbConnection()
	{
	 try
	 {
		 Class.forName("com.ibm.db2.jcc.DB2Driver");              //Driver Load
		 con=DriverManager.getConnection("jdbc:db2://localhost:50000/GENPOL","db2admin","db2admin");    //create connection
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
	public int NewConInsert()
	{
		int n=0;
		try
		{
			 pst=con.prepareStatement("insert into db2admin.constitute values(?,?,?,?)");
			 pst.setInt(1, cons_no);
			 pst.setString(2, district);
			 pst.setString(3, state);
			 pst.setString(4, country);
			 n=pst.executeUpdate();
			 System.out.print(n);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return n;
	}
	public ResultSet viewConstitute()
	{
		
		try
		{
		pst=con.prepareStatement("select * from db2admin.constitute where district=? and state=? and country=?");
		pst.setString(1,district);
		pst.setString(2, state);
		pst.setString(3, country);
		rs=pst.executeQuery();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
}
