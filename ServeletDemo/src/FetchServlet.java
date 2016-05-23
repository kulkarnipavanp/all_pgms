import java.io.*;
import java.sql.*;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class FetchServlet
 */
@WebServlet("/FetchServlet")
public class FetchServlet {

	PreparedStatement ps;
	
	public void init(ServletConfig config) throws ServletException {
		System.out.println("inside init of Fetch Servlet");
		
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pavan_schema", "root", "root");
			ps = con.prepareStatement("select * from employee where eid = ?");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("inside service method of Fetch Servlet");
		
		response.setContentType("text/html");
		
		PrintWriter pw = response.getWriter();
		pw.println("<h3>Record : </h3>");
		
		String eid = request.getParameter("eid_fh");
		
		try{
			ps.setInt(1, Integer.parseInt(eid));
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				pw.println("<form action = ModifyServlet align=centre method= post><table>");
				pw.println("<tr><td>EID</td><td><input type=text name=eid_fs value="+rs.getInt(1)+"></td></tr>");
				pw.println("<tr><td>First Name</td><td><input type=text name=fname_fs value="+rs.getString(2)+"></td></tr>");
				pw.println("<tr><td>Last Name</td><td><input type=text name=lname_fs value="+rs.getString(3)+"></td></tr>");
				
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				
				pw.println("<tr><td>Click to Update</td><td><input type=submit name=UPDATE></td></tr>");
				pw.println("</table>");
				pw.println("</form>");
			}
			else
				pw.println("<h3>Record Not Found</h3>");
			
			
			pw.println("<a href = Fetch.html> back </a>");
			
		}
		catch (Exception e){
			e.printStackTrace();
			
		}
		
		
	}

}
