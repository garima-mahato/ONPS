package pollingPack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Users {
	String user_id;
	
	
	String password;
	String user_type;
    Connection con=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUser_type() {
		return user_type;
	}
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
	public String getEmail_id() {
		return user_id;
	}
	
	
	
	public void dbConnection()
	{
		try
		{
			Class.forName("com.ibm.db2.jcc.DB2Driver");
			System.out.println("here1111");
			con=DriverManager.getConnection("jdbc:db2://localhost:50000/GENPOL","db2admin","db2admin");
			System.out.println("here2222");
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
	public int update(String s)
	{
		int n=0;
		try
		{
			pst=con.prepareStatement("update db2admin.USER_LOGIN set pwd=? where pwd=? and uid=? and utype=?");
			pst.setString(1,s);
			pst.setString(2,password);
			pst.setString(3, user_id);
			pst.setString(4, user_type);
			n=pst.executeUpdate();
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return n;
	}
	public int checklogin()
	{
		
		int n=0;
		try
		{
			pst=con.prepareStatement("select * from  db2admin.USER_LOGIN where uid=? and pwd=? and utype=?");
			pst.setString(1,user_id);
			pst.setString(2,password);
			pst.setString(3,user_type);
			rs=pst.executeQuery();
			if(rs.next())
			{
			n=1;	
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return n;
	}
	public int changePwd(String p)
	{
		int n=0;
		try
		{
			PreparedStatement pst1=con.prepareStatement("select * from user_login where uid=?");
			pst1.setString(1,user_id);
			 rs=pst1.executeQuery();
			String s1=null,s2=null,s3=null;
			while(rs.next())
			{
			 s1=rs.getString(1);
			 s2=rs.getString(2);
			 s3=rs.getString(3);
			}
			if((s1.equals(user_id)==true)&&(s2.equals(password)==true))
			{
			 pst=con.prepareStatement("update db2admin.user_login set pwd=? where uid=?");
			 pst.setString(1,p);
			 pst.setString(2,user_id);
			 n=pst.executeUpdate();
			}
	    }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return n;
	}

	
	
	}






