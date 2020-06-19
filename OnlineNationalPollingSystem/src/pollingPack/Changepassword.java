package pollingPack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Changepassword
 */
public class Changepassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Changepassword() {
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
					Users u=new Users();
					System.out.println("s1="+s1);
					HttpSession ses=request.getSession(false);
					u.setPassword(s1);
					String uid=(String)ses.getAttribute("uid");
					String utype=(String)ses.getAttribute("utype");
					u.setUser_id(uid);
					u.setUser_type(utype);
					u.dbConnection();
					int n=u.update(s2);
					//int n=pst.executeUpdate();
					u.dbClose();
				
					if(n==1)
							{
								out.print("password change successfully completed");
							}
							else
							{
								out.print("password updation failed");
							}
				}
				catch(Exception e)
				{
					out.print("updation failed");
					e.printStackTrace();
					
					
				
			}

	}

}
