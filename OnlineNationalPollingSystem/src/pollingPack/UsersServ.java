package pollingPack;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pollingPack.Users;

/**
 * Servlet implementation class UsersServ
 */
public class UsersServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsersServ() {
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
		String s1=request.getParameter("t1");
		String s2=request.getParameter("t2");
		String s3=request.getParameter("t3");
		Users u=new Users();
		System.out.println("s1="+s1+"s2="+s2+"s3="+s3);
		u.setUser_id(s1);
		u.setPassword(s2);
		u.setUser_type(s3);
		u.dbConnection();
		int n=u.checklogin();
		u.dbClose();
		HttpSession ses;
		if(n==1)
		{
			ses=request.getSession(true);
			ses.setAttribute("uid",s1);
			ses.setAttribute("utype",s3);
			if(s3.equals("Voter"))
				{
			response.sendRedirect("Welcome_Voter.jsp");
		}
		else if(s3.equals("Candidate")) // checking if 2nd radio button checked or not?
		{
			response.sendRedirect("Welcome_Candidate.jsp");
		}
		else if(s3.equals("Field Officer")) //checking if 3rd radio button checked or not?
		{
			response.sendRedirect("Welcome_Field_Officer.jsp");
		}
		else if(s3.equals("Commissioner"))
		{
			response.sendRedirect("WelcomeCommissioner.jsp");
}
		}
		else
		{
			response.sendRedirect("errormsg.jsp?p=2");
		}
	}

}
