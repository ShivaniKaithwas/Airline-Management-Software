package Admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/adminlogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String em1=request.getParameter("em");
		String pwd1=request.getParameter("pwd");
		  PrintWriter out=response.getWriter();
		  try
		  {
			   Class.forName("com.mysql.jdbc.Driver");
			   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","root","root");
			   PreparedStatement ps=con.prepareStatement("select * from  administrator where login_id=? and password=? ");
			   ps.setString(1,em1);
			   ps.setString(2,pwd1);
			   
			   ResultSet rs=ps.executeQuery();
			    
			    if(rs.next())
			    {
			    	out.println("Login Successfully..!");
			    	
			    	RequestDispatcher re=request.getRequestDispatcher("ShowDetailsofCustomer.java");
			    	re.include(request, response);
			    	//out.print("<a href=show>Show Details customers</a>");
			    	
			    	//response.sendRedirect("show");
			    }
			    else
			    {

			    	out.println("Login Not Successfully..!");
			    }
		  }
		  catch(Exception ref)
		  {
			  System.out.println(ref);
		  }
	}

}
