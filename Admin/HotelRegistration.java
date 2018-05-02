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
@WebServlet("/hotel")
public class HotelRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HotelRegistration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String fn1=request.getParameter("data_1");
		String ln1=request.getParameter("data_2");
		String con1=request.getParameter("data_3");
		String em1=request.getParameter("data_4");

		String ad1=request.getParameter("data_5");
		String dd1=request.getParameter("data_6");
		String na1=request.getParameter("data_7");

		String ch1=request.getParameter("data_8");
		String q1=request.getParameter("data_9");
		
		

	    System.out.println(" the Question  = "+q1);
	    
	    PrintWriter out=response.getWriter();
		  try
		  {
			   Class.forName("com.mysql.jdbc.Driver");
			   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","root","root");
			   PreparedStatement ps=con.prepareStatement("insert into hotels(fname,lname,phone,email,adob,ddob,ad,ch,cm) values(?,?,?,?,?,?,?,?,?)");			   
			   
			   ps.setString(1,fn1);
			   ps.setString(2,ln1);
			   ps.setString(3,con1);
			   ps.setString(4,em1);
			   ps.setString(5,ad1);
			   ps.setString(6,dd1);
			   ps.setString(7,na1);
			   ps.setString(8,ch1);
			   ps.setString(9, q1);
			  
			   
			int i=ps.executeUpdate();
			    
			System.out.println(ps );
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
