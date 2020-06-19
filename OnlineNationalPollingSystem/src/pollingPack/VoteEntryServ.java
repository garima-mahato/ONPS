package pollingPack;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class VoteEntryServ
 */
public class VoteEntryServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VoteEntryServ() {
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
		
		String s3=request.getParameter("t3");
		String s4=request.getParameter("t4");
		String s5=request.getParameter("t5");
		//String s6=request.getParameter("t6");
		HttpSession ses=request.getSession(false);
		String s2=(String)ses.getAttribute("uid");
		Vote v=new Vote();
		v.setE_id(s1);
		v.setVoterid(s2);
		v.setCandidate_id(s3);
		v.setCandidate_name(s4);
		v.setParty_name(s5);
		//v.setStatus(s6);
		v.dbConnection();
		int n=v.vInsert();
		v.dbClose();
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
