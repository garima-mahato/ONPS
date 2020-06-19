package pollingPack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pollingPack.Users;

/**
 * Servlet implementation class Update_PasswordServ
 */
public class Update_PasswordServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update_PasswordServ() {
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
		PrintWriter out=response.getWriter();
		try
		{
				String s1=request.getParameter("t1");
				String s2=request.getParameter("t2");
				String s3=request.getParameter("t3");
				if(s2.equals(s3)==false)
				{
					out.print("Passwords did not match");
					
				}
				else
				{
					Users u=new Users();
					HttpSession ses=request.getSession(false);
					u.setPassword(s1);
					String uid=(String)ses.getAttribute("uid");
					String utype=(String)ses.getAttribute("utype");
					u.setUser_id(uid);
					u.setUser_type(utype);
					u.dbConnection();
					int n=u.changePwd(s2);
					u.dbClose();
				    if(n>0)
					{
				    	int n1=0;
						
						if(utype.equals("Voter"))
						{
							Candidate c=new Candidate();
							c.dbConnection();
							n1=c.pwdUpdate(s2);
							c.dbClose();
							if(n1==1)
							{
								response.sendRedirect("successms.jsp");
							}
							else
							{
								response.sendRedirect("errmsg.jsp");
							}
							
						}
						if(utype.equals("Candidate"))
						{
							Candidate c=new Candidate();
							c.dbConnection();
							n1=c.pwdUpdate(s2);
							c.dbClose();
							if(n1==1)
							{
								response.sendRedirect("successmsg.jsp?p=1");
							}
							else
							{
								response.sendRedirect("errormsg.jsp?p=3");
							}
						}
						if(utype.equals("Field Officer"))
						{
							response.sendRedirect("successmsg.jsp?p=1");
						}
						if(utype.equals("Election Commissioner"))
						{
							response.sendRedirect("successmsg.jsp?p=1");
						}
					
						
					}
				    else
				    {
				    	response.sendRedirect("errormsg.jsp?p=3");
				    }
					
				}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
