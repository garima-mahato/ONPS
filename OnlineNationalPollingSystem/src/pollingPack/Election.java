package pollingPack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Election {
	int e_id,cons_no;
	String district,state,country,e_type,e_date;
	Connection con=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	
	public int getE_id() {
		return e_id;
	}
	public void setE_id(int e_id) {
		this.e_id = e_id;
	}
	public int getCons_no() {
		return cons_no;
	}
	public void setCons_no(int cons_no) {
		this.cons_no = cons_no;
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
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getE_type() {
		return e_type;
	}
	public void setE_type(String e_type) {
		this.e_type = e_type;
	}
	public String getE_date() {
		return e_date;
	}
	public void setE_date(String e_date) {
		this.e_date = e_date;
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
	public int eInsert()
	{
		int n=0;
		try
		{
			 pst=con.prepareStatement("insert into db2admin.election(e_id,cons_no,district,state,country,e_type,e_date) values(?,?,?,?,?,?,?)");
			 pst.setInt(1,e_id);
			 pst.setInt(2, cons_no);
			 pst.setString(3, district);
			 pst.setString(4, state);
			 pst.setString(5, country);
			 pst.setString(6, e_type);
			 pst.setString(7, e_date);
			 n=pst.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return n;
	}
	public int eUpdate()
	{
		int n=0;
		try
		{
			 pst=con.prepareStatement("update db2admin.election set e_date=? where e_id=?)");
			 
			 pst.setInt(1, e_id);
			 pst.setString(2, e_date);
			 n=pst.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return n;
	}
	public ResultSet display()
	{
		try
		{
			 pst=con.prepareStatement("select *from db2admin.election");
			 rs=pst.executeQuery();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	public ResultSet display1()
	{
		try
		{
			 pst=con.prepareStatement("select cons_no,district,state,country,e_type,e_date from db2admin.election order by cons_no");
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
			 pst=con.prepareStatement("select cons_no,district,state,country,e_type,e_date from db2admin.election order by district");
			 rs=pst.executeQuery();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	public ResultSet display3()
	{
		try
		{
			 pst=con.prepareStatement("select cons_no,district,state,country,e_type,e_date from db2admin.election order by state");
			 rs=pst.executeQuery();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	public ResultSet display4()
	{
		try
		{
			 pst=con.prepareStatement("select cons_no,district,state,country,e_type,e_date from db2admin.election order by country");
			 rs=pst.executeQuery();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	public int getid()
	{
		int id=0;
		try
		{
		pst=con.prepareStatement("select e_id from db2admin.election where cons_no=? and district=? and state=? and e_date=current date");
		pst.setInt(1,cons_no);
		pst.setString(2,district);
		pst.setString(3,state);
		rs=pst.executeQuery();
		while(rs.next())
		{
			id=rs.getInt(1);
		}
		}
		catch(Exception e)
		{
		e.printStackTrace();	
		}
		return id;
	}
	public ResultSet display5()
	{
		try
		{
			 pst=con.prepareStatement("select e_id,cons_no,district,state,country,e_type,e_date from db2admin.election where cons_no=? and district=? and state=? and country=?");
			 pst.setInt(1,cons_no);
			 pst.setString(2,district);
			 pst.setString(3,state);
			 pst.setString(4,country);
			 rs=pst.executeQuery();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
public ResultSet display6()
	{
		try
		{
			 pst=con.prepareStatement("select e_id,cons_no,district,state,country,e_type,e_date from db2admin.election where district=? and state=? and country=?");
			 pst.setString(1,district);
			 pst.setString(2,state);
			 pst.setString(3,country);
			 rs=pst.executeQuery();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	public ResultSet display7()
	{
		try
		{
			 pst=con.prepareStatement("select e_id,cons_no,district,state,country,e_type,e_date from db2admin.election where state=? and country=?");
			 pst.setString(1,state);
			 pst.setString(2,country);
			 rs=pst.executeQuery();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	public ResultSet display8()
	{
		try
		{
			 pst=con.prepareStatement("select e_id,cons_no,district,state,country,e_type,e_date from db2admin.election where country=?");
			 pst.setString(1,country);
			 rs=pst.executeQuery();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
}
