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
@WebServlet("/bk")
public class BookingRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookingRegistration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String f1=request.getParameter("f");
		String t1=request.getParameter("t");
		
		String fno1=request.getParameter("fno");
		String em1=request.getParameter("em");
		String dob1=request.getParameter("dob");

		String d8=request.getParameter("data_8");
		String d9=request.getParameter("data_9");
		String d10=request.getParameter("data_10");
		String d11=request.getParameter("data_11");
		String d12=request.getParameter("data_12");
		
		String d13=request.getParameter("data_13");

		

	    System.out.println(f1);
	    System.out.println(t1);
	    System.out.println(em1);
	    System.out.println(fno1);
	    System.out.println(dob1);
	    System.out.println(d8);
	    System.out.println(d9);
	    System.out.println(d10);
	    System.out.println(d11);
		
	    PrintWriter out=response.getWriter();
		  try
		  {
			   Class.forName("com.mysql.jdbc.Driver");
			   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","root","root");
			   PreparedStatement ps=con.prepareStatement("insert into booking( origin ,destination ,email, flight_no,dob,col1_one_way,col2_sp ,col3 ,col4_acc,economic , comment) values(?,?,?,?,?,?,?,?,?,?,?)");			   
			   ps.setString(1,f1);
			   ps.setString(2,t1);
			   ps.setString(3,em1);
			   ps.setString(4,fno1);
			   ps.setString(5,dob1);
			   ps.setString(6,d8);
			   ps.setString(7,d9);
			   ps.setString(8,d10);
			   ps.setString(9, d11);
			   ps.setString(10, d12);
			   ps.setString(11,d13);
			  
			   
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
