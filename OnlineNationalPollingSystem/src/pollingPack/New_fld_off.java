package pollingPack;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pollingPack.Field_Officer;

/**
 * Servlet implementation class New_fld_off
 */
public class New_fld_off extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public New_fld_off() {
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
		String s1=request.getParameter("t1");
		String s2=request.getParameter("t2");
		String s3=request.getParameter("t3");
		String s4=request.getParameter("t4");
		String s5=request.getParameter("t5");
		//String s6=request.getParameter("t6");
		
		
		System.out.println(s1+s2+s3+s4+s5);
		Field_Officer ft=new Field_Officer();
		ft.setFid(s1);
		ft.setVoter_id(s2);
		ft.setConstituency(Integer.parseInt(s3));
		ft.setDistrict(s4);
		ft.setState(s5);
		ft.setStatus("EXIST");
		//ft.setExpired_date(s6);
	
		
		
		ft.dbConnection();
		int n=ft.Insert();
		ft.dbClose();
		if(n==1)
		{
			response.sendRedirect("successms.jsp");
		}
		else
		{
			response.sendRedirect("errmsg.jsp");
			
		}
	}
		   catch(Exception e)
		   {
			   e.printStackTrace();
		   }

	}

}
