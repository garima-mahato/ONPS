package pollingPack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Party {
	//String party_id;
	String p_name,p_head,logoFile;
	byte []x=null;

	Connection con=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	/*(public String getParty_id() {
		return party_id;
	}
	public void setParty_id(String party_id) {
		this.party_id = party_id;
	}*/
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public String getP_head() {
		return p_head;
	}
	public void setP_head(String p_head) {
		this.p_head = p_head;
	}
	public String getLogoFile() {
		return logoFile;
	}
	public void setLogoFile(String logoFile) {
		this.logoFile = logoFile;
	}
	public byte[] getX() {
		return x;
	}
	public void setX(byte[] x) {
		this.x = x;
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
	public int NewPartyInsert()
	{
		int n=0;
		try
		{
			 pst=con.prepareStatement("insert into db2admin.party values(?,?,?,?)");
			// pst.setString(1, party_id );
			 pst.setString(1, p_name);
			 pst.setString(2, p_head);
			 pst.setBytes(3, x);
			 pst.setString(4, logoFile);
			 n=pst.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return n;
	}
	public ResultSet viewProfile()
	{
		
		try
		{
		pst=con.prepareStatement("select * from db2admin.party where party_name=?");
		pst.setString(1,p_name);
		rs=pst.executeQuery();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet partyImg()
	{
		try
		{
			pst=con.prepareStatement("select logo from db2admin.party where logo_file=?");
			pst.setString(1,logoFile);
			rs=pst.executeQuery();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	public String getfilename()
	{
		String file=null;
		try
		{
			pst=con.prepareStatement("select logo_file from db2admin.party where pname=?");
			pst.setString(1,p_name);
			rs=pst.executeQuery();
			while(rs.next())
			{
				file=rs.getString(1);
			}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return file;
	}
}
