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
@WebServlet("/reg")
public class CustomerRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerRegistration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String fn1=request.getParameter("fn");
		String ln1=request.getParameter("ln");
		String mob1=request.getParameter("mob");
		String em1=request.getParameter("em");
		String pwd1=request.getParameter("pwd");

		String adate1=request.getParameter("adate");
		String dep1=request.getParameter("dep");
		
		int ad1=Integer.parseInt(request.getParameter("adults"));
		int ch1=Integer.parseInt(request.getParameter("children"));
		
		String msg1=request.getParameter("msg");
		

	    System.out.println(fn1);
		  PrintWriter out=response.getWriter();
		  try
		  {
			   Class.forName("com.mysql.jdbc.Driver");
			   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","root","root");
			   PreparedStatement ps=con.prepareStatement("insert into customer(fname,lname,mobile,email,password,arrival_date,departure_date,adults,children,message) values(?,?,?,?,?,?,?,?,?,?) ");
			   ps.setString(1,fn1);
			   ps.setString(2,ln1);
			   ps.setString(3,mob1);
			   ps.setString(4,em1);
			   ps.setString(5,pwd1);
			   ps.setString(6,adate1);
			   ps.setString(7,dep1);
			   ps.setInt(8,ad1);
			   ps.setInt(9,ch1);
			   ps.setString(10,msg1);
			   
			int i=ps.executeUpdate();
			    
			    if(i==1)
			    {
			    	out.println("Registration Successfully..!");
			    }
			    else
			    {

			    	out.println("Registration Not Successfully..!");
			    }
			    
			    System.out.println("Working...!");
		  }
		  catch(Exception ref)
		  {
			  System.out.println(ref);
		  }
	}

}
