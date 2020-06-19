package pollingPack;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import pollingPack.Voter;

/**
 * Servlet implementation class New_Voter_AppServ
 */
public class New_Voter_AppServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public New_Voter_AppServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		 String s1=null,s2=null,s3=null,s4=null,s5=null,s6=null,s7=null,s8=null,s9=null,s10=null,s11=null,s12=null;
		 byte[]  xx=null;
		 byte[]  xx1=null;
		 byte[] xx2=null;
		 String fname1="";
		 String fname2="";
		 String fname3="";
		   FileItemFactory factory = new DiskFileItemFactory();
		   ServletFileUpload upload = new ServletFileUpload(factory);
		   List items = null;
		   try {
		   items = upload.parseRequest(request);
		   
		   Iterator itr = items.iterator();
		   while (itr.hasNext()) 
			   {
		   FileItem item = (FileItem) itr.next();
		   
		   if (item.isFormField())
			   {
			          String name = item.getFieldName();
				  String value = item.getString();
				  if(name.equals("t1"))
			           {  s1=value;   }
			          if(name.equals("t2"))
			           { s2=value;   }
			          if(name.equals("t3"))
			           { s3=value;   }
			          if(name.equals("t4"))
			           { s4=value;   }
			          if(name.equals("t5"))
			           { s5=value;   }
			          if(name.equals("t6"))
			           { s6=value;   }
			          if(name.equals("t7"))
			           { s7=value;   }
			          if(name.equals("t8"))
			           { s8=value;   }
			          if(name.equals("t9"))
			           { s9=value;   }
			          if(name.equals("t10"))
			           {
			        	  s10=value; 
			        	  }
			          
			        	  if(name.equals("t11"))
			        	  {
			        		  s11=value;
			        	  }
			        	  if(name.equals("t12"))
			        	  {
			        		  s12=value;
			        	  }
			        	  
			          
		          } 
		   else
			   {

		    if(xx==null)
		    {
		   xx = item.get();
		   String itemName = item.getName();
		   fname1= itemName.substring(itemName.lastIndexOf("\\")+1);
		   fname1=fname1.replace(" ","");
		  // String x = "C:\\Documents and Settings\\db2admin\\Desktop\\img\\"+fname1;
		  // File savedFile = new File(x);
		   System.out.println("filename : "+fname1);
		  // item.write(savedFile);
		    }
		    else if(xx1==null)
		    {
		    	xx1 = item.get();
				   String itemName = item.getName();
				   fname2= itemName.substring(itemName.lastIndexOf("\\")+1);
				   fname2=fname2.replace(" ","");
				  // String x = "C:\\Documents and Settings\\db2admin\\Desktop\\img\\"+fname2;
				   //File savedFile = new File(x);
				   System.out.println("filename2 : "+fname2);
				   //item.write(savedFile);
		    }
		    else
		    {
		    	xx2 = item.get();
				   String itemName = item.getName();
				   fname3= itemName.substring(itemName.lastIndexOf("\\")+1);
				   fname3=fname3.replace(" ","");
				  // String x = "C:\\Documents and Settings\\db2admin\\Desktop\\img\\"+fname2;
				   //File savedFile = new File(x);
				   System.out.println("filename3 : "+fname3);
				   //item.write(savedFile);
		   
		    }
		   
			   }
			   }

		
		PrintWriter out=response.getWriter();
		Voter v1=new Voter();
		v1.setName(s1);
		v1.setDob(s2);
		v1.setGender(s3);
		v1.setAge(s4);
		v1.setAddress(s5);
		v1.setPhone(s6);
		v1.setEmailid(s7);
		v1.setPhoto(xx);
		v1.setDistrict(s8);
		v1.setState(s9);
		v1.setCountry(s10);
		v1.setDb_file(xx1);
		v1.setRes_file(xx2);
		v1.setGdname(s12);
		v1.setCons(Integer.parseInt(s11));
		v1.setFile1(fname1);
		v1.setFile2(fname2);
		v1.setFile3(fname3);
		v1.dbConnection();
		int n=v1.newAppInsert();
		v1.dbClose();
		if(n==1)
		{
			response.sendRedirect("successmsg.jsp?p=1");
		}
		else
		{
			response.sendRedirect("errormsg.jsp?p=1");
			
		}
	}
		   catch(Exception e)
		   {
			   e.printStackTrace();
		   }

	}

	}


