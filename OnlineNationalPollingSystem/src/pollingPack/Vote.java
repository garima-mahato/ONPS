package pollingPack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Vote {

	int e_id;
	String voterid,candidate_id,candidate_name,party_name,status;
	String fid;
	Connection con=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	public int getE_id() {
		return e_id;
	}
	public void setE_id(int e_id) {
		this.e_id = e_id;
	}
	public String getVoterid() {
		return voterid;
	}
	public void setVoterid(String voterid) {
		this.voterid = voterid;
	}
	public String getCandidate_id() {
		return candidate_id;
	}
	public void setCandidate_id(String candidate_id) {
		this.candidate_id = candidate_id;
	}
	public String getCandidate_name() {
		return candidate_name;
	}
	public void setCandidate_name(String candidate_name) {
		this.candidate_name = candidate_name;
	}
	public String getParty_name() {
		return party_name;
	}
	public void setParty_name(String party_name) {
		this.party_name = party_name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void  dbConnection()
	{
	 try
	 {
		 Class.forName("com.ibm.db2.jcc.DB2Driver");              //Driver Load
		 con=DriverManager.getConnection("jdbc:db2://localhost:50000/GENPOL2","db2admin","db2admin");    //create connection
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
	public int vInsert()
	{
		int n=0;
		try
		{
			 pst=con.prepareStatement("insert into db2admin.vote values(?,?,?,?,?,?)");
			 pst.setInt(1, e_id);
			 pst.setString(2, voterid);
			 pst.setString(3, candidate_id);
			 pst.setString(4, candidate_name);
			 pst.setString(5, party_name);
			 pst.setString(6, "Casted");
			 n=pst.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return n;
	}
	public int countVote()
	{
		int n=0;
		try
		{
			PreparedStatement pst5=con.prepareStatement("select * from db2admin.field_officer where fid=?");
			pst5.setString(1,fid);
			ResultSet rs5=pst5.executeQuery();
		  int consno=0;
		  String dist=null;
		  String state=null;
		  while(rs5.next())
		  {
			  consno=rs5.getInt(3);
			  dist=rs5.getString(4);
			  state=rs5.getString(5);
		  }
			PreparedStatement pst2=con.prepareStatement("select count(*),candidate_id from db2admin.vote where status=? and candidate_id in(select cid from db2admin.candidate where constituency=? and district=? and state=?)  group by candidate_id");
			pst2.setString(1, "Casted");
			pst2.setInt(2,consno);
			pst2.setString(3,dist);
			pst2.setString(4,state);
			ResultSet rs2=pst2.executeQuery();
			while(rs2.next())
			{
				int cn=rs2.getInt(1);
				String cid=rs2.getString(2);
				PreparedStatement pst1=con.prepareStatement("select * from db2admin.candidate  where cid=?");
				pst1.setString(1,cid);
				ResultSet rs1=pst1.executeQuery();
				String cname=null;
				String pname=null;
				int eid=0;
				while(rs1.next())
				{
					cname=rs1.getString(1);
					pname=rs1.getString(8);
					eid=rs1.getInt(18);
				}
				PreparedStatement pst3=con.prepareStatement("insert into db2admin.vote_result values(?,?,?,?,?,?,current date,null)");
				pst3.setInt(1,eid);
				pst3.setString(2,cid);
				pst3.setString(3,cname);
				pst3.setString(4,pname);
				pst3.setInt(5,cn);
				pst3.setString(6,"Counted");
				pst3.executeUpdate();
				PreparedStatement pst4=con.prepareStatement("update db2admin.vote set status='Counted' where e_id=?");
				pst4.setInt(1, eid);
			    n=pst4.executeUpdate();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return n;

	}
	public ResultSet view()
	{
		try
		{
			pst=con.prepareStatement("select * from db2admin.vote where status=?");
			pst.setString(1,"Casted");
			rs=pst.executeQuery();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rs;
		}
	public ResultSet viewCommissioner()
	{
		try
		{
			pst=con.prepareStatement("select * from db2admin.vote_result where status=?");
			pst.setString(1,"Counted");
			rs=pst.executeQuery();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rs;
		}
	 public int publishResult()
	 {          
		        int n=0;
				try
				{
					pst=con.prepareStatement("update vote_result set status=? , publish_date=current date where status=?");
					pst.setString(1, "Published");
					pst.setString(2,"Counted");
					n=pst.executeUpdate();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				return n;
	 }
	 public ResultSet publishResult1()
	 {
			try
			{
				pst=con.prepareStatement("select e_id from vote_result where status=? and publish_date=current date");
				pst.setString(1, "Published");
				ResultSet rs1=pst.executeQuery();
				String eid=null;
				while(rs1.next())
				{
					eid=rs1.getString(1);
				}
					PreparedStatement pst1=con.prepareStatement("select c.name,c.party_name,c.constituency,c.district,c.state,c.country,c.e_id,v.count_vote from db2admin.candidate c,db2admin.vote_result v where c.e_id=v.e_id and  v.e_id=?");
					pst1.setString(1,eid);
					rs=pst1.executeQuery();
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return rs;
	 }
	 
	 public ResultSet voteResult(String eid)
	 {
			try
			{
					pst=con.prepareStatement("select c.name,c.party_name,c.constituency,c.district,c.state,c.country,c.e_id,v.count_vote from db2admin.candidate c,db2admin.vote_result v where c.e_id=v.e_id and  v.e_id=? and v.status=?");
					pst.setString(1,eid);
					pst.setString(2,"Published");
					rs=pst.executeQuery();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return rs;
	 }
	 public ResultSet result(int eid)
	 {
			try
			{
					pst=con.prepareStatement("select party_name,sum(count_vote) from vote_result where e_id=? and status=? group by party_name having sum(count_vote)=(select max(c) from(select sum(count_vote) as c from vote_result where e_id=? and status=? group by party_name))");
					pst.setInt(1,eid);
					pst.setString(2,"Published");
					pst.setInt(3,eid);
					pst.setString(4,"Published");
					rs=pst.executeQuery();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return rs;
	 }
	 public int votingstatus()
	 {
		 int st=0;
		 try
		 {
			pst=con.prepareStatement("select * from db2admin.vote where e_id=? and voterid=?") ;
			pst.setInt(1,e_id);
			pst.setString(2,voterid);
			rs=pst.executeQuery();
			while(rs.next())
			{
				st=1;
			}
			
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 return st;
	 }
	 public int countingstatus()
	 {
		 int st=0;
		 try
		 {
			pst=con.prepareStatement("select * from db2admin.vote v,db2admin.election e where v.e_id=e.e_id and v.e_id=? and e.count_date=current date and v.status=?") ;
			pst.setInt(1,e_id);
			pst.setString(2,"Casted");
			rs=pst.executeQuery();
			while(rs.next())
			{
				st=1;
			}
			
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 return st;
	 }
	 public ResultSet result()
	 {
		 try
		 {
			 pst=con.prepareStatement("select sum(count_vote) from db2admin.vote_result group by party_name");
			 pst.setString(1, party_name);
			 rs=pst.executeQuery();
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 return rs;
	 }

}
