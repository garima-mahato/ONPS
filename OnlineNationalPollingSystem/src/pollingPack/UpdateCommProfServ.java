package pollingPack;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class UpdateCommProfServ
 */
public class UpdateCommProfServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCommProfServ() {
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
			           {  s1=value;  
			           System.out.println(s1);}
			          if(name.equals("t2"))
			           { s2=value; 
			           System.out.println(s2);}
		          } 
		   else
		    {
		   xx = item.get();
		   String itemName = item.getName();
		   fname= itemName.substring(itemName.lastIndexOf("\\")+1);
		   fname=fname.replace(" ","");
		  // String x = "C:\\Documents and Settings\\db2admin\\Desktop\\img\\"+fname1;
		  // File savedFile = new File(x);
		   System.out.println("filename : "+fname);
		  // item.write(savedFile);
		   
		    }}
		 HttpSession ses=request.getSession(false);
		 String uid=(String)ses.getAttribute("uid");
		 ElectionCommissioner ec=new ElectionCommissioner();
		 ec.setComm_id(uid);
		 ec.setEd_qualification(s1);
		 ec.setExperience(s2);
		 ec.setPhoto(xx);
		 ec.setF(fname);
		 ec.dbConnection();
		 int n=ec.update();
		 ec.dbClose();
		 if(n==1)
		 {
			 response.sendRedirect("successmsg.jsp?p=2");
		 }
		 else
		 {
			 response.sendRedirect("errormsg.jsp?p=2");
		 }

			   }
		    catch(Exception e)
		   {
			   e.printStackTrace();
		   }

	}

}
