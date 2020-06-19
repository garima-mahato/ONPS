package pollingPack;

import java.io.IOException;
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

/**
 * Servlet implementation class NewCanAppServ
 */
public class NewCanAppServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewCanAppServ() {
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
		 String s1=null,s2=null,s3=null,s4=null,s5=null,s6=null,s7=null,s8=null,s9=null,s10=null;
		 byte[]  xx=null;
		 byte[]  xx1=null;
		 
		 String fname1="";
		 String fname2="";
		 
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
			          if(name.equals("t5"))
			           { s4=value;   }
			          if(name.equals("t7"))
			           { s5=value;   }
			          if(name.equals("t8"))
			           { s6=value;   }
			          if(name.equals("t9"))
			           { s7=value;   }
			          if(name.equals("t10"))
			           { s8=value;   }
			          if(name.equals("t11"))
			           { s9=value;   }
			        	 
			          if(name.equals("t12"))
			           { s10=value;   }
			        	 
			          
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
		    else
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
		   /* else
		    {
		    	xx2 = item.get();
				   String itemName = item.getName();
				   fname3= itemName.substring(itemName.lastIndexOf("\\")+1);
				   fname3=fname3.replace(" ","");
				  // String x = "C:\\Documents and Settings\\db2admin\\Desktop\\img\\"+fname2;
				   //File savedFile = new File(x);
				   System.out.println("filename3 : "+fname3);
				   //item.write(savedFile);
		   
		    }*/
		   
			   }
			   }

		
		//PrintWriter out=response.getWriter();
		Candidate c=new Candidate();
		c.setName(s1);
		c.setVid(s2);
		c.setEmail(s3);
		c.setPhoto(xx);
		c.setQualification(s4);
		c.setEd(xx1);
		c.setConstituency(Integer.parseInt(s5));
		c.setParty(s6);
		c.setDistrict(s7);
		c.setState(s8);
		c.setCountry(s9);
		c.setF1(fname1);
		c.setF2(fname2);
		c.setE_id(Integer.parseInt(s10));
		c.dbConnection();
		int n=c.NewCanInsert();
		c.dbClose();
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
