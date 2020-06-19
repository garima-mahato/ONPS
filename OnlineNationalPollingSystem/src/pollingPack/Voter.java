package pollingPack;


	import java.io.PrintWriter;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;

	import com.ibm.CORBA.iiop.Response;
import com.ibm.ejs.j2c.haproxy.DispatchHAGroupCallbackPackage.byteArrayHelper;

	public class Voter {
		
		String name;
		String dob;
		String gender;
		String age;
		String new_address;
		String address;
		String phone;
		String uid;
		String uname;
		String utype;
		String emailid;
		String district;
		String state;
		String country;
		String status;
		int cons;
		String voter_Id;
		String gdname;
		byte[] photo;
		byte[] db_file;
		byte[] res_file;
		String file1;
		String file2;
		String file3;
		String pass;
		
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		public String getStatus() {
			return name;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public String getName() {
			return name;
		}
		public String getUid() {
			return uid;
		}
		public void setUid(String uid) {
			this.uid = uid;
		}
		public String getUname() {
			return uname;
		}
		public void setUname(String uname) {
			this.uname = uname;
		}
		public String getUtype() {
			return utype;
		}
		public void setUtype(String utype) {
			this.utype = utype;
		}
		public void setVoter_Id(String voter_id) {
			this.voter_Id = voter_id;
		}
		public String getVoter_Id() {
			return voter_Id;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDob() {
			return dob;
		}
		public void setDob(String dob) {
			this.dob = dob;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getAge() {
			return age;
		}
		public void setAge(String age) {
			this.age = age;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getEmailid() {
			return emailid;
		}
		public void setEmailid(String emailid) {
			this.emailid = emailid;
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
		public int getCons() {
			return cons;
		}
		public void setCons(int cons) {
			this.cons = cons;
		}
		public String getGdname() {
			return gdname;
		}
		public void setNewAddress(String new_address) {
			this.new_address = new_address;
		}
		public String getNewAddress() {
			return new_address;
		}
		public void setGdname(String gdname) {
			this.gdname = gdname;
		}
		public byte[] getPhoto() {
			return photo;
		}
		public void setPhoto(byte[] photo) {
			this.photo = photo;
		}
		public byte[] getDb_file() {
			return db_file;
		}
		public void setDb_file(byte[] db_file) {
			this.db_file = db_file;
		}
		public byte[] getRes_file() {
			return res_file;
		}
		public void setRes_file(byte[] res_file) {
			this.res_file = res_file;
		}
		public String getFile1() {
			return file1;
		}
		public void setFile1(String file1) {
			this.file1 = file1;
		}
		public String getFile2() {
			return file2;
		}
		public void setFile2(String file2) {
			this.file2 = file2;
		}
		public String getFile3() {
			return file3;
		}
		public void setFile3(String file3) {
			this.file3 = file3;
			
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
		
		public int newAppInsert()
		{
			
			int n=0;
			try
			{
				pst=con.prepareStatement("insert into db2admin.new_voter_app values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,current date,?,?,?)");
				pst.setString(1,name);
				pst.setString(2,dob);
				pst.setString(3,gender);
				pst.setString(4,age);
				pst.setString(5,address);
				pst.setString(6,phone);
				pst.setString(7,emailid);
				pst.setBytes(8, photo);
				pst.setString(9,district);
				pst.setString(10,state);
				pst.setString(11,country);
				pst.setString(12, "Applied");
				pst.setInt(13, cons);
				pst.setBytes(14, db_file);
				pst.setBytes(15,res_file);
				pst.setString(16, gdname);
				
				pst.setString(17,file1);
				pst.setString(18,file2);
				pst.setString(19,file3);
		
				n=pst.executeUpdate();
				
				
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return n;
		} 

		
		public ResultSet showimag(String email)
		{
	 try
	 {
		 pst=con.prepareStatement("select  photo from db2admin.new_voter_app where email_id=?");
		 pst.setString(1,email);
		 rs=pst.executeQuery();
	 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
				
				return rs;
			}
		public ResultSet showimags(String voter_Id)
		{
	 try
	 {
		 pst=con.prepareStatement("select  photo from db2admin.voter where voterid=?");
		 pst.setString(1,voter_Id);
		 rs=pst.executeQuery();
	 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
				
				return rs;
			}
		
	 public ResultSet showimag1(String email)
		{
	try
	{
		 pst=con.prepareStatement("select  age_proof from db2admin.new_voter_app where email_id=?");
		 pst.setString(1,email);
		 rs=pst.executeQuery();
	}
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
			
			return rs;
		}
	 public ResultSet showimags1(String voter_Id)
		{
	try
	{
		 pst=con.prepareStatement("select  age_proof from db2admin.voter where voterid=?");
		 pst.setString(1,voter_Id);
		 rs=pst.executeQuery();
	}
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
				
				return rs;
			}
	 public ResultSet showimag2(String email)
		{
	try
	{
		 pst=con.prepareStatement("select  residential_proof from db2admin.new_voter_app where email_id=?");
		 pst.setString(1,email);
		 rs=pst.executeQuery();
	}

	catch(Exception e)
	{
		 e.printStackTrace();
	}
			
			return rs;
		}
	 public ResultSet showimags2(String voter_Id)
		{
	try
	{
		 pst=con.prepareStatement("select  residential_proof from db2admin.voter where voterid=?");
		 pst.setString(1,voter_Id);
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
				pst=con.prepareStatement("select * from db2admin.New_Voter_app where status=?");
				pst.setString(1,"Applied");
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
				pst=con.prepareStatement("select * from db2admin.Voter where voterid=?");
				pst.setString(1,voter_Id);
				rs=pst.executeQuery();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return rs;
			}
		public ResultSet view1()
		{
			try
			{
				pst=con.prepareStatement("select * from db2admin.NEW_VOTER_APP where status=?");
				pst.setString(1,"Verified");
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
				pst=con.prepareStatement("update db2admin.New_Voter_App set status=? where Email_Id=?");
				pst.setString(2,emailid);
				pst.setString(1, status);
				n=pst.executeUpdate();
		}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return n;
		}
		public int changeadd()
		{
			
			int n=0;
			try
			{
				pst=con.prepareStatement("insert into db2admin.voter_address_app values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,current date,?,?,?,?,?)");
				pst.setString(1,name);
				pst.setString(2,dob);
				pst.setString(3,gender);
				pst.setString(4,age);
				pst.setString(5,address);
				pst.setString(6,phone);
				pst.setString(7,emailid);
				pst.setBytes(8, photo);
				pst.setString(9,district);
				pst.setString(10,state);
				pst.setString(11,country);
				pst.setString(12,"Applied");
			
				pst.setInt(13, cons);
				pst.setBytes(14, db_file);
				pst.setBytes(15,res_file);
				pst.setString(16, gdname);
				pst.setString(17,file1);
				pst.setString(18,file2);
				pst.setString(19,file3);
					pst.setString(20,new_address);
				pst.setString(21,voter_Id);
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
				pst=con.prepareStatement("select * from db2admin.voter");
				rs=pst.executeQuery();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return rs;
			}
		public void IssueCard()
		{
			
			int n=0;
			try
			{
				int count=0;
				pst=con.prepareStatement("select * from db2admin.NEW_VOTER_APP where status=?");
				pst.setString(1,"Verified");
				rs=pst.executeQuery();
				String s1=null,s2=null,s3=null,s4=null,s5=null,s6=null,s7=null,s9=null,s10=null,s11=null,s12=null,s16=null,s17=null;
			int x=0;
				byte[]  xx=null; 
				byte[] xx1=null;
				byte[] xx2=null;
				String fname1="";
				String fname2="";
				String fname3="";
				
				while(rs.next())
				{
					count++;
				s1=rs.getString(1);
				s2=rs.getString(2);
				s3=rs.getString(3);
				s4=rs.getString(4);
				s5=rs.getString(5);
				s6=rs.getString(6);
				s7=rs.getString(7);
				xx=rs.getBytes(8);
				xx1=rs.getBytes(14);
				xx2=rs.getBytes(15);
				x=rs.getInt(13);
			    s9=rs.getString(9);
				s10=rs.getString(10);
				s11=rs.getString(11);
				s12=rs.getString(12);
				s16=rs.getString(16);
				s17=rs.getString(17);
				fname1=rs.getString(18);
				fname2=rs.getString(19);
				fname3=rs.getString(20);
				double d1=Math.random();
				d1=d1*1000000;
				String vid="ABC"+d1;
				vid=vid.substring(0,6);
				double d2=Math.random();
				d2=d2*1000000;
				String pwd="XYZ"+d2;
				pwd=pwd.substring(0,6);
				
				PreparedStatement pst2=con.prepareStatement("insert into db2admin.voter values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				pst2.setString(1,s1);
				pst2.setString(2,s2);
				pst2.setString(3,s3);
				pst2.setString(4,s4 );
				pst2.setString(5,s5);
				pst2.setString(6,s6);
				pst2.setString(7,s7);
				pst2.setBytes(8,xx);
				pst2.setString(9,s9);
				pst2.setString(10,s10);
				pst2.setString(11,s11);
				pst2.setString(12,s12);
				pst2.setBytes(14,xx1);
				pst2.setInt(13,x);
				pst2.setBytes(15,xx2);
				pst2.setString(16,s16);
			    pst2.setString(17,s17);
				pst2.setString(18,fname1);
				pst2.setString(19,fname2);
				pst2.setString(20,fname3);
				pst2.setString(21,vid);
				pst2.setString(22,pwd);
				
				
				pst2.executeUpdate();
				
				
				
				PreparedStatement pst3=con.prepareStatement("insert into db2admin.user_login values (?,?,?)");
					pst3.setString(1,vid);
					pst3.setString(2,pwd);
					pst3.setString(3,"Voter");
				 pst3.executeUpdate();
				
				PreparedStatement pst4=con.prepareStatement("delete from db2admin.new_voter_app where email_id=?");
				pst4.setString(1,s7);
				pst4.executeUpdate();
				
				MailPro mp=new MailPro();
				String msg="Your Voter card has been issued.. Your VoterId="+vid +" and Password="+pwd;
				String sub="Voter Card Issued";
				mp.postMail(s7,sub, msg);	
				}
			}
			
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		public ResultSet display3()
		{
			try
			{
				pst=con.prepareStatement("select * from db2admin.New_Voter_App where status=?");
				pst.setString(1,"Verified");
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
				pst=con.prepareStatement("select * from db2admin.Voter");
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
			pst=con.prepareStatement("select name from db2admin.voter where voterid=?");
			pst.setString(1,voter_Id);
			rs=pst.executeQuery();
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return rs;
		}	
		
		public ResultSet getcons_dist()
		{
			try
			{
				pst=con.prepareStatement("select * from db2admin.voter where voterid=?");
				pst.setString(1,voter_Id);
				rs=pst.executeQuery();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return rs;
		}
		public int pwdUpdate(String s)
		{
			int n=0;
			try
			{
				
				pst=con.prepareStatement("update db2admin.voter set pwd=? where voterid=?");
				pst.setString(1,s);
				pst.setString(2,voter_Id);
				n=pst.executeUpdate();
		    }
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return n;
		}

	}
		