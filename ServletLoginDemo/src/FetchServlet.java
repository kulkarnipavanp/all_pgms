import java.io.*;
import java.sql.*;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class FetchServlet
 */
@WebServlet("/FetchServlet")
public class FetchServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;


	PreparedStatement ps;
	
	public void init(ServletConfig config) throws ServletException {
		System.out.println("inside init of Fetch Servlet");
		
		try{
			
			ServletContext ctx = config.getServletContext();
			String driver = ctx.getInitParameter("driver");
			String url = ctx.getInitParameter("url");
			String username = ctx.getInitParameter("username");
			String passwd = ctx.getInitParameter("password");
			
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, username, passwd);
			ps = con.prepareStatement("select * from Persons where id = ?");
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
		
		String id = request.getParameter("pid_fh");
		
		try{
			ps.setInt(1, Integer.parseInt(id));
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				pw.println("<form action = ModifyServlet align=centre method= post><table>");
				pw.println("<tr><td>ID</td><td><input type=text name=pid_fs value="+rs.getInt(1)+"></td></tr>");
				pw.println("<tr><td>First Name</td><td><input type=text name=fname_fs value="+rs.getString(2)+"></td></tr>");
				pw.println("<tr><td>Last Name</td><td><input type=text name=lname_fs value="+rs.getString(3)+"></td></tr>");
				pw.println("<tr><td>Address </td><td><input type=text name=address_fs value="+rs.getString(4)+"></td></tr>");
				pw.println("<tr><td>City </td><td><input type=text name=city_fs value="+rs.getString(5)+"></td></tr>");
				
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));
				System.out.println(rs.getString(5));
				
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
