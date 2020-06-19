package pollingPack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Candidate {
	String cid,vid,name,email,qualification,party,district,state,country,date,status,pwd;
	int constituency,e_id;
	String f1,f2;
	byte []ed=null;
	byte []photo=null;
	
	Connection con=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getParty() {
		return party;
	}
	public void setParty(String party) {
		this.party = party;
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getConstituency() {
		return constituency;
	}
	public void setConstituency(int constituency) {
		this.constituency = constituency;
	}
	public String getF1() {
		return f1;
	}
	public void setF1(String f1) {
		this.f1 = f1;
	}
	public String getF2() {
		return f2;
	}
	public void setF2(String f2) {
		this.f2 = f2;
	}
	public byte[] getEd() {
		return ed;
	}
	public void setEd(byte[] ed) {
		this.ed = ed;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public int getE_id() {
		return e_id;
	}
	public void setE_id(int e_id) {
		this.e_id = e_id;
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
	public int NewCanInsert()
	{
		int n=0;
		try
		{
			 pst=con.prepareStatement("insert into db2admin.candidate_app values(?,?,?,?,?,?,?,?,current date,?,?,?,?,?,?,?)");
			 pst.setString(1, name);
			 pst.setString(2, vid);
			 pst.setString(3, email);
			 pst.setBytes(4, photo);
			 pst.setString(5, qualification);
			 pst.setBytes(6,ed);
			 pst.setInt(7, constituency);
			 pst.setString(8,party);
			 
			 pst.setString(9,district);
			 pst.setString(10,state);
			 pst.setString(11,country);
			 pst.setString(12,"Applied");
			 pst.setString(13,f1);
			 pst.setString(14,f2);
			 pst.setInt(15, e_id);
			 n=pst.executeUpdate();             //sql statement execute
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
		pst=con.prepareStatement("select * from db2admin.candidate where cid=?");
		pst.setString(1,cid);
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
		pst=con.prepareStatement("select name from db2admin.candidate where cid=?");
		pst.setString(1,cid);
		rs=pst.executeQuery();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	
	
	public ResultSet viewcandApp()
	{
		try
		{
			pst=con.prepareStatement("select * from db2admin.candidate_app where status=?");
			pst.setString(1,"Applied");
			rs=pst.executeQuery();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rs;
		}
	public int updatestatus()
	{
		int n=0;
		try
		{
			
			pst=con.prepareStatement("update db2admin.candidate_App set status=? where Email_Id=?");
			pst.setString(2,email);
			pst.setString(1, status);
			n=pst.executeUpdate();
	    }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return n;
	}
	public int approveCandidature()
	{
		int n=0;
		try
		{
			pst=con.prepareStatement("select * from db2admin.candidate_App where email_id=?");
			pst.setString(1,email);
			rs=pst.executeQuery();
			String s1=null,s2=null,s3=null,s4=null,s5=null,s6=null,s7=null,s8=null,s9=null,s10=null,s11=null;int s12=0;
			byte []x1=null;
			byte []x2=null;int cn=0;
			while(rs.next())
			{
				s1=rs.getString(1);
				s2=rs.getString(2);
				s3=rs.getString(3);
				x1=rs.getBytes(4);
				s4=rs.getString(5);
				x2=rs.getBytes(6);
				cn=rs.getInt(7);
				s5=rs.getString(8);
				s6=rs.getString(9);
				s7=rs.getString(10);
				s8=rs.getString(11);
				s9=rs.getString(12);
				s10=rs.getString(14);
				s11=rs.getString(15);
				s12=rs.getInt(16);
			}
			
			double d1=Math.random();
			d1=d1*1000000;
			String sd1="CAN"+d1;
			String c_id=sd1.substring(0,6);
			double d2=Math.random();
			d2=d2*1000000;
			String sd2="PAS"+d2;
			String pwd=sd2.substring(0,6);
			PreparedStatement pst2=con.prepareStatement("insert into db2admin.candidate values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pst2.setString(1, s1);
			pst2.setString(2, s2);
		    pst2.setString(3, s3);
		    pst2.setBytes(4, x1);
			pst2.setString(5, s4);
			pst2.setBytes(6,x2);
			pst2.setInt(7, cn);
			pst2.setString(8,s5);
			pst2.setString(9,s6);
			pst2.setString(10,s7);
			pst2.setString(11,s8);
			pst2.setString(12,s9);
			pst2.setString(13,"Confirmed");
			pst2.setString(14,s10);
			pst2.setString(15,s11);
			pst2.setString(16,c_id);
			pst2.setString(17,pwd);
			pst2.setInt(18, s12);
			pst2.executeUpdate(); 
			
			PreparedStatement pst3=con.prepareStatement("insert into db2admin.user_login values(?,?,?)");
			pst3.setString(1, c_id);
			pst3.setString(2, pwd);
			pst3.setString(3, "Candidate");
			pst3.executeUpdate();
			
			PreparedStatement pst4=con.prepareStatement("delete from db2admin.candidate_app where email_id=?");
			pst4.setString(1,email);
			n=pst4.executeUpdate();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return n;
		}
	public int pwdUpdate(String s)
	{
		int n=0;
		try
		{
			
			pst=con.prepareStatement("update db2admin.candidate set password=? where cid=?");
			pst.setString(1,s);
			pst.setString(2,cid);
			n=pst.executeUpdate();
	    }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return n;
	}
	public ResultSet getCandidates()
	{
		try
		{
			pst=con.prepareStatement("select * from db2admin.candidate where e_id=? and constituency=? and district=? and state=? ");
			pst.setInt(1,e_id);
			pst.setInt(2,constituency);
			pst.setString(3,district);
			pst.setString(4,state);
			rs=pst.executeQuery();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return rs;
	}
	public ResultSet showimagCan(String email)
	{
     try
     {
	   pst=con.prepareStatement("select  photo from db2admin.candidate_app where email_id=?");
	   pst.setString(1,email);
	   rs=pst.executeQuery();
     }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
			
			return rs;
	}
	public ResultSet showimagCan1(String email)
	{
     try
     {
	  pst=con.prepareStatement("select  ed_qualification_proof from db2admin.candidate_app where email_id=?");
	  pst.setString(1,email);
	  rs=pst.executeQuery();
     }
     catch(Exception e)
     {
	  e.printStackTrace();
     }
	 return rs;
	}
	public ResultSet showimagCan2(String id)
	{
     try
     {
	   pst=con.prepareStatement("select  photo from db2admin.candidate where cid=?");
	   pst.setString(1,id);
	   rs=pst.executeQuery();
     }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
			
			return rs;
	}
	public ResultSet showimagCan3(String id)
	{
     try
     {
	  pst=con.prepareStatement("select  ed_qualification_proof from db2admin.candidate where cid=?");
	  pst.setString(1,id);
	  rs=pst.executeQuery();
     }
     catch(Exception e)
     {
	  e.printStackTrace();
     }
	 return rs;
	}
	

}



