package pollingPack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ElectionCommissioner {
	String comm_id,vid,name,ed_qualification,experience;
	String f;
	byte []photo=null;
	
	Connection con=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	public String getComm_id() {
		return comm_id;
	}
	public void setComm_id(String comm_id) {
		this.comm_id = comm_id;
	}
	public String getVid() {
		return vid;
	}
	public void setVid(String vid) {
		this.vid = vid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEd_qualification() {
		return ed_qualification;
	}
	public void setEd_qualification(String ed_qualification) {
		this.ed_qualification = ed_qualification;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getF() {
		return f;
	}
	public void setF(String f) {
		this.f = f;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
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
	public int newCommInsert()
	{
		int n=0;
		try
		{
			 pst=con.prepareStatement("insert into db2admin.election_commissioner values(?,?,?,?,?,?,?)");
			 pst.setString(1, comm_id);
			 pst.setString(2, name);
			 pst.setString(3, vid);
			 pst.setString(4, ed_qualification);
			 pst.setString(5, experience);
			 pst.setBytes(6, photo);
			 pst.setString(7,f);
			 n=pst.executeUpdate();             //sql statement execute
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return n;
	}
	
	public int update()
	{
		int n=0;
		try
		{
			 pst=con.prepareStatement("update db2admin.election_commissioner set ed_qualification=?,prof_experience=?,image=?,image_file=? where comm_id=?");
			 
			 pst.setString(1, ed_qualification);
			 pst.setString(2, experience);
			 pst.setBytes(3, photo);
			 pst.setString(4, f);
			 pst.setString(5, comm_id);
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
		pst=con.prepareStatement("select * from db2admin.election_commissioner where comm_id=?");
		pst.setString(1,comm_id);
		rs=pst.executeQuery();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	public ResultSet viewName()
	{
		
		try
		{
		pst=con.prepareStatement("select name from db2admin.election_commissioner where comm_id=?");
		pst.setString(1,comm_id);
		rs=pst.executeQuery();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	
}
