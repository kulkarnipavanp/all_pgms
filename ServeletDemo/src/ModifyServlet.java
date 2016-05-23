

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class ModifyServlet
 */
@WebServlet("/ModifyServlet")
public class ModifyServlet  {
		
	PreparedStatement ps;
	
	public void init(ServletConfig config) throws ServletException {
		System.out.println("inside init of Modify Servlet");
		
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pavan_schema", "root", "root");
			ps = con.prepareStatement("update employee set eid=?, fname=?, lname=? where eid = ?");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	
  
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("inside service method of Modify Servlet");
		
		response.setContentType("text/html");
		
		PrintWriter pw = response.getWriter();
		pw.println("<h1> Record Updated !! </h1>");
		
		String eid = request.getParameter("eid_fs");
		String first = request.getParameter("fname_fs");
		String last = request.getParameter("lname_fs");
		
		
		
		try{
			
			ps.setString(1, eid);
			ps.setString(2, first);
			ps.setString(3, last);
			ps.setString(4, eid);
			
			int res = ps.executeUpdate();
			
			if(res>0)
				pw.println("<h3>record inserted successfully</h3>");
			
			pw.println("<a href = Fetch.html> Change another record </a>");
			pw.println("<a href = Funtionality.html> Home </a>");
			
		}
		catch (Exception e){
			e.printStackTrace();
			
		}
		
	}

}
