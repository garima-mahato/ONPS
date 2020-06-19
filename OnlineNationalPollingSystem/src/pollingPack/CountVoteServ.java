package pollingPack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CountVoteServ
 */
public class CountVoteServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CountVoteServ() {
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
		PrintWriter	out=response.getWriter();
		Vote  vt1=new Vote();
		HttpSession ses=request.getSession(false);
		String uid=(String)ses.getAttribute("uid");
		String utype=(String)ses.getAttribute("utype");
		vt1.setFid(uid);
		vt1.dbConnection();
	    int n=vt1.countVote();
	    vt1.dbClose();
	    if(n==1)
	     out.print("Votes Counted");
	    else
	     response.sendRedirect("errormsg.jsp?p=4");
	}

}
