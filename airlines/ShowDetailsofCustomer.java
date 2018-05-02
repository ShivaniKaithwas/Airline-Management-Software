package Admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/show")
public class ShowDetailsofCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowDetailsofCustomer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  PrintWriter out=response.getWriter();
		  try
		  {
			   Class.forName("com.mysql.jdbc.Driver");
			   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","root","root");
			   PreparedStatement ps=con.prepareStatement("select * from  customer");
			
			   ResultSet rs=ps.executeQuery();
			    
			    while(rs.next())
			    {
			    	out.print(rs.getString(1)+" ");
			    	out.print(rs.getString(2)+" ");
			    	out.print(rs.getString(3)+" ");
			    	out.print(rs.getString(4)+" ");
			    	out.print(rs.getString(6)+" ");
			    	out.print(rs.getString(7)+" ");
			    	out.print(rs.getInt(8)+" ");
			    	out.print(rs.getInt(9)+" ");
			    	out.println(rs.getString(10)+" ");
			    }
		
		  }
		  catch(Exception ref)
		  {
			  System.out.println(ref);
		  }
	}

}
