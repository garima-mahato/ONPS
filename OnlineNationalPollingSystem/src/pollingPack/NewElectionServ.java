package pollingPack;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NewElectionServ
 */
public class NewElectionServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewElectionServ() {
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
		try
		{
		int s1=Integer.parseInt(request.getParameter("t1"));
		int s2=Integer.parseInt(request.getParameter("t2"));
		String s3=request.getParameter("t3");
		String s4=request.getParameter("t4");
		String s5=request.getParameter("t5");
		String s6=request.getParameter("t6");
		String s7=request.getParameter("t7");
		Election cons=new Election();
		cons.setE_id(s1);
		cons.setCons_no(s2);
		cons.setDistrict(s3);
		cons.setState(s4);
		cons.setCountry(s5);
		cons.setE_type(s6);
		cons.setE_date(s7);
		cons.dbConnection();
		int n=cons.eInsert();
		cons.dbClose();
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
