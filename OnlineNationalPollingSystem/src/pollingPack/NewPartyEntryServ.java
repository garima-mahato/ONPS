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
 * Servlet implementation class NewPartyEntryServ
 */
public class NewPartyEntryServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewPartyEntryServ() {
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
		 String s1=null,s2=null;
		 byte[]  xx=null;
		 
		 
		 String fname="";
		 
		 
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
			         /* if(name.equals("t3"))
			           { s3=value;   }*/
			          
			        	 
			          
		          } 
		   else
			   {

		    if(xx==null)
		    {
		   xx = item.get();
		   String itemName = item.getName();
		   fname= itemName.substring(itemName.lastIndexOf("\\")+1);
		   fname=fname.replace(" ","");
		  // String x = "C:\\Documents and Settings\\db2admin\\Desktop\\img\\"+fname1;
		  // File savedFile = new File(x);
		   System.out.println("filename : "+fname);
		  // item.write(savedFile);
		   
		    }
		   
		   
			   }
			   }
		   //System.out.print(s1+s2+s3+fname);
		Party p=new Party();
		
		//p.setParty_id(s1);
		p.setP_name(s1);
		p.setP_head(s2);
		p.setX(xx);
		p.setLogoFile(fname);
		p.dbConnection();
		int n=p.NewPartyInsert();
		p.dbClose();
		//System.out.print(n);
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
